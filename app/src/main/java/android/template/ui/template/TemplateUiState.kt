/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.ui.template

import android.template.domain.model.TemplateModel
import android.template.ui.state.UiState

data class TemplateUiState(
    override var isLoading: Boolean,
    override var error: Throwable?,
    override var data: List<TemplateModel>
): UiState<List<TemplateModel>>()