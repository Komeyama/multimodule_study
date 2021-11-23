package com.komeyama.multimodule.study

import android.app.Application
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.CoreComponentProvider
import com.komeyama.multimodule.study.corecomponent.di.CoreModule
import com.komeyama.multimodule.study.corecomponent.di.DaggerCoreComponent
import timber.log.Timber

class MainApplication : Application(), CoreComponentProvider {

    val coreComponent by lazy {
        DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        timber()
    }

    private fun timber() {
        Timber.plant(Timber.DebugTree())
    }
}