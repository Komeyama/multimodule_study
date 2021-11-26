package com.komeyama.multimodule.study.feature_b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.corecomponent.di.CoreComponentProvider
import com.komeyama.multimodule.study.corecomponent.di.FragmentKey
import com.komeyama.multimodule.study.feature_b.databinding.FragmentFeatureBBinding
import com.komeyama.multimodule.study.feature_b.di.DaggerFeatureBComponent
import com.komeyama.multimodule.study.feature_b.di.FeatureBComponent
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import timber.log.Timber
import javax.inject.Inject

class FeatureBFragment @Inject constructor(private var router: FeatureBRouter) :
    Fragment(R.layout.fragment_feature_b) {

    companion object {
        const val TITLE_KEY = "title_key"
    }

    private lateinit var coreComponent: CoreComponent
    private lateinit var component: FeatureBComponent
    private var _binding: FragmentFeatureBBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FeatureBViewModel by viewModels(factoryProducer = {
        (component.viewModelFactory())
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = arguments?.getString(TITLE_KEY)
        Timber.d("args: $args")

        coreComponent =
            (requireActivity().application as? CoreComponentProvider)?.provideCoreComponent()
                ?: throw IllegalStateException()

        component = DaggerFeatureBComponent
            .builder()
            .coreComponent(coreComponent)
            .build()

        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeatureBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.button.setOnClickListener {
            router.navigateToFeatureA()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

@Module
interface FeatureBFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(FeatureBFragment::class)
    fun bindFeatureAFragment(fragment: FeatureBFragment): Fragment
}