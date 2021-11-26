package com.komeyama.multimodule.study.router

import android.os.Bundle
import com.komeyama.multimodule.study.R.id.fragment_container
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.komeyama.multimodule.study.di.MainFragmentFactory
import com.komeyama.multimodule.study.feature_a.FeatureAFragment
import com.komeyama.multimodule.study.feature_a.FeatureARouter
import com.komeyama.multimodule.study.feature_b.FeatureBFragment
import com.komeyama.multimodule.study.feature_b.FeatureBFragment.Companion.TITLE_KEY
import com.komeyama.multimodule.study.feature_b.FeatureBRouter
import javax.inject.Inject

class RouterA @Inject constructor(
    private val fragmentManager: FragmentManager,
    private val fragmentFactory: MainFragmentFactory
) : FeatureARouter {

    override fun navigateToFeatureB(title: String) {

        val fragmentB = fragmentFactory.instantiate(
            FeatureBFragment::class.java.classLoader!!,
            FeatureBFragment::class.java.name
        )

        val bundle = Bundle()
        bundle.putString(TITLE_KEY, title)
        fragmentB.arguments = bundle

        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            fragment_container,
            fragmentB
        )
        fragmentTransaction.addToBackStack(FeatureAFragment::class.java.name)
        fragmentTransaction.commit()
    }
}

class RouterB @Inject constructor(private val fragmentManager: FragmentManager) : FeatureBRouter {

    override fun navigateToFeatureA() {
        fragmentManager.popBackStack()
    }
}