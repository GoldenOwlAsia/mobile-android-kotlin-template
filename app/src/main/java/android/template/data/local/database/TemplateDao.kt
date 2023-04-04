/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.data.local.database

import android.template.domain.model.TemplateModel
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Query("SELECT * FROM template ORDER BY uid DESC LIMIT 10")
    fun getTemplates(): Flow<List<TemplateModel>>

    @Insert
    suspend fun insertTemplate(item: TemplateModel)
}