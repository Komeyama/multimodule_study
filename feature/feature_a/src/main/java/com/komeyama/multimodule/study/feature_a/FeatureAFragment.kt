package com.komeyama.multimodule.study.feature_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.CoreComponentProvider
import com.komeyama.multimodule.study.corecomponent.di.FragmentKey
import com.komeyama.multimodule.study.feature_a.databinding.FragmentABinding
import com.komeyama.multimodule.study.feature_a.di.DaggerFeatureAComponent
import com.komeyama.multimodule.study.feature_a.di.FeatureAComponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import timber.log.Timber
import javax.inject.Inject

class FeatureAFragment @Inject constructor(var router: FeatureARouter): Fragment(R.layout.fragment_a) {

    private lateinit var coreComponent: CoreComponent
    private lateinit var component: FeatureAComponent
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Timber.d("viewModelA: $viewModel")
        binding.button.setOnClickListener {
            router.navigateToFeatureB("detail title")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

@Module
interface FeatureAFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(FeatureAFragment::class)
    fun bindFeatureAFragment(fragment: FeatureAFragment): Fragment
}