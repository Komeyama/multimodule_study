package com.komeyama.multimodule.study.feature_b.di

import androidx.lifecycle.ViewModel
import com.komeyama.multimodule.study.corecomponent.di.ViewModelKey
import com.komeyama.multimodule.study.feature_b.FeatureBViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FeatureBModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeatureBViewModel::class)
    abstract fun bindFeatureAViewModel(viewModel: FeatureBViewModel): ViewModel
}