package com.komeyama.multimodule.study.di

import androidx.fragment.app.FragmentManager
import com.komeyama.multimodule.study.MainActivity
import com.komeyama.multimodule.study.feature_a.FeatureARouter
import com.komeyama.multimodule.study.feature_b.FeatureBRouter
import com.komeyama.multimodule.study.router.RouterA
import com.komeyama.multimodule.study.router.RouterB
import dagger.Module
import dagger.Provides

@Module
class RouterModule(private val activity: MainActivity) {

    @Provides
    fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    fun provideRouterA(
        fragmentManager: FragmentManager,
        fragmentFactory: MainFragmentFactory
    ): FeatureARouter {
        return RouterA(fragmentManager, fragmentFactory)
    }

    @Provides
    fun provideRouterB(fragmentManager: FragmentManager): FeatureBRouter {
        return RouterB(fragmentManager)
    }
}