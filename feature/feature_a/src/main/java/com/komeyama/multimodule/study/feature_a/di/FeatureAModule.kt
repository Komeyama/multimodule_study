package com.komeyama.multimodule.study.feature_a.di

import androidx.lifecycle.ViewModel
import com.komeyama.multimodule.study.feature_a.FeatureAViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureAModule {

    @Binds
    abstract fun bindFeatureAViewModel(viewModel: FeatureAViewModel): ViewModel
}