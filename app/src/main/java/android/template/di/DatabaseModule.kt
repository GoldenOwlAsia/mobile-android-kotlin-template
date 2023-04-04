/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.di

import android.content.Context
import android.template.data.local.database.TemplateDao
import android.template.data.local.database.TemplateDatabase
import android.template.data.local.repository.DefaultTemplateRepository
import android.template.domain.repository.TemplateRepository
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideTemplateDao(appDatabase: TemplateDatabase): TemplateDao {
        return appDatabase.templateDao()
    }

    @Provides
    @Singleton
    fun provideRepository(dao: TemplateDao): TemplateRepository {
        return DefaultTemplateRepository(dao)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): TemplateDatabase {
        return Room.databaseBuilder(
            appContext,
            TemplateDatabase::class.java,
            "TemplateDatabase"
        ).build()
    }
}
