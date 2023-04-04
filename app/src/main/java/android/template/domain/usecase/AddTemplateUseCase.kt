/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.domain.usecase

import android.template.domain.model.TemplateModel
import android.template.domain.repository.TemplateRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddTemplateUseCase(
    private val repository: TemplateRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(model: TemplateModel) = flow {
        try {
            repository.insertTemplate(model)
            emit(true)
        } catch (_: Exception) {
            emit(false)
        }
    }.flowOn(dispatcher)
}