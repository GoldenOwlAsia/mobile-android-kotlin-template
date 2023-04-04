/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.data.local.database

import android.template.domain.model.TemplateModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TemplateModel::class], version = 1)
abstract class TemplateDatabase : RoomDatabase() {
    abstract fun templateDao(): TemplateDao
}
