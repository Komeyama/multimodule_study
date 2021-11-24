package com.komeyama.multimodule.study.feature_a.di

import androidx.lifecycle.ViewModel
import com.komeyama.multimodule.study.corecomponent.di.ViewModelKey
import com.komeyama.multimodule.study.feature_a.FeatureAViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FeatureAModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeatureAViewModel::class)
    abstract fun bindFeatureAViewModel(viewModel: FeatureAViewModel): ViewModel
}