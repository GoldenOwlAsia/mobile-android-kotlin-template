/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.ui.viewmodel

import android.template.domain.model.TemplateModel
import android.template.domain.usecase.AddTemplateUseCase
import android.template.domain.usecase.GetTemplateListUseCase
import android.template.ui.template.TemplateUiState
import android.template.util.Async
import android.template.util.WhileUiSubscribed
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val addTemplateUseCase: AddTemplateUseCase,
    private val getTemplateListUseCase: GetTemplateListUseCase,

) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    private val _templateListAsync = getTemplateListUseCase()
        .map { Async.Success(it) }
        .catch<Async<List<TemplateModel>>> { emit(Async.Error(it)) }

    val uiState: StateFlow<TemplateUiState> = combine(
        _isLoading, _templateListAsync
    ) { isLoading, templateListAsync ->
        when (templateListAsync) {
            Async.Loading -> {
                TemplateUiState(isLoading = true, null, listOf())
            }
            is Async.Error -> {
                TemplateUiState(isLoading = false, templateListAsync.throwable, listOf())
            }
            is Async.Success -> {
                TemplateUiState(isLoading = false, null, templateListAsync.data)
            }
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = WhileUiSubscribed,
            initialValue = TemplateUiState(isLoading = true, null, listOf())
        )


    private val _addTemplateEvent = MutableSharedFlow<Boolean>()
    val addTemplateEvent = _addTemplateEvent.asSharedFlow()

    fun addTemplate(name: String) {
        viewModelScope.launch {
            addTemplateUseCase.invoke(TemplateModel(name))
                .collect{
                    _addTemplateEvent.emit(it)
                }

        }
    }
}
