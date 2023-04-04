/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.data.local.repository

import android.template.data.local.database.TemplateDao
import android.template.domain.model.TemplateModel
import android.template.domain.repository.TemplateRepository
import kotlinx.coroutines.flow.Flow

class DefaultTemplateRepository(private val templateDao: TemplateDao) : TemplateRepository {
    override fun getTemplates(): Flow<List<TemplateModel>> {
        return templateDao.getTemplates()
    }

    override suspend fun insertTemplate(item: TemplateModel) {
        templateDao.insertTemplate(item)
    }
}