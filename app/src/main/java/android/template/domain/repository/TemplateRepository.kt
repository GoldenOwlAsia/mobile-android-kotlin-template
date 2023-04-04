/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.domain.repository

import android.template.domain.model.TemplateModel
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {
    fun getTemplates(): Flow<List<TemplateModel>>

    suspend fun insertTemplate(item: TemplateModel)
}