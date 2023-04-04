/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.di
import android.template.domain.repository.TemplateRepository
import android.template.domain.usecase.AddTemplateUseCase
import android.template.domain.usecase.GetTemplateListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideAddTemplate(repository: TemplateRepository): AddTemplateUseCase {
        return AddTemplateUseCase(repository = repository)
    }

    @Provides
    fun provideGetTemplateList(repository: TemplateRepository): GetTemplateListUseCase {
        return GetTemplateListUseCase(repository)
    }

}
