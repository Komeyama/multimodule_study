package com.komeyama.multimodule.study.di

import androidx.lifecycle.ViewModel
import com.komeyama.multimodule.study.MainViewModel
import com.komeyama.multimodule.study.corecomponent.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}