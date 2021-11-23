package com.komeyama.multimodule.study.feature_a

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.komeyama.multimodule.study.corecomponent.di.CoreComponentProvider
import com.komeyama.multimodule.study.feature_a.di.DaggerFeatureAComponent
import javax.inject.Inject

class FeatureAFragment : Fragment(R.layout.fragment_a) {

    @Inject lateinit var viewModel: FeatureAViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coreComponent =
            (requireActivity().application as? CoreComponentProvider)?.provideCoreComponent()
                ?: throw IllegalStateException()

        val component = DaggerFeatureAComponent
            .builder()
            .coreComponent(coreComponent)
            .build()

        component.inject(this)

        viewModel.serviceA1()
    }

}