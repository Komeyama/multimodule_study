package com.komeyama.multimodule.study.usecase_a.internal

import android.content.Context
import com.komeyama.multimodule.study.usecase_a.UseCaseA
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Inject

internal class UseCaseAImpl @Inject constructor(private val context: Context) : UseCaseA {
    override fun serviceA1() {
        Timber.d("call serviceA1, pacage name:${context.packageName}")
    }
}

@Module
class UseCaseAModule {

    @Provides
    fun provideUseCaseAImpl(context: Context): UseCaseA {
        return UseCaseAImpl(context)
    }
}