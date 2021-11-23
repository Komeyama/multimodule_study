package com.komeyama.multimodule.study.corecomponent.di

import android.content.Context
import com.komeyama.multimodule.study.usecase_a.UseCaseA
import com.komeyama.multimodule.study.usecase_a.UseCaseAComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideUseCaseA(
        useCaseAComponent: UseCaseAComponent
    ): UseCaseA {
        return useCaseAComponent.useCaseA()
    }

    @Singleton
    @Provides
    fun provideUseCaseAComponent(): UseCaseAComponent {
        return UseCaseAComponent.factory().create(context)
    }
}
