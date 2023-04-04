/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.testdi

import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import android.template.data.MyModelRepository
import android.template.data.di.FakeMyModelRepository

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
interface FakeDataModule {

    @Binds
    abstract fun bindRepository(
        fakeRepository: FakeMyModelRepository
    ): MyModelRepository
}
