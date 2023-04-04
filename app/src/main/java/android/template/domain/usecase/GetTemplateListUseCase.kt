/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.domain.usecase

import android.template.domain.model.TemplateModel
import android.template.domain.repository.TemplateRepository
import kotlinx.coroutines.flow.Flow

class GetTemplateListUseCase (private val repository: TemplateRepository) {
    operator fun invoke(): Flow<List<TemplateModel>> {
        return repository.getTemplates()
    }
}