package com.komeyama.multimodule.study.feature_a

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.CoreComponentProvider
import com.komeyama.multimodule.study.feature_a.di.DaggerFeatureAComponent
import com.komeyama.multimodule.study.feature_a.di.FeatureAComponent

class FeatureAFragment : Fragment(R.layout.fragment_a) {

    private lateinit var coreComponent: CoreComponent
    private lateinit var component: FeatureAComponent

    private val viewModel: FeatureAViewModel by viewModels(factoryProducer = {
        (component.viewModelFactory())
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coreComponent =
            (requireActivity().application as? CoreComponentProvider)?.provideCoreComponent()
                ?: throw IllegalStateException()

        component = DaggerFeatureAComponent
            .builder()
            .coreComponent(coreComponent)
            .build()

        component.inject(this)

        viewModel.serviceA1()
    }

}