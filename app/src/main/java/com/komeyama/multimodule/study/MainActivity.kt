package com.komeyama.multimodule.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.komeyama.multimodule.study.corecomponent.di.CoreComponent
import com.komeyama.multimodule.study.di.AppComponent
import com.komeyama.multimodule.study.di.DaggerAppComponent
import com.komeyama.multimodule.study.feature_a.FeatureAFragment

class MainActivity : AppCompatActivity() {

    private lateinit var coreComponent: CoreComponent
    private lateinit var component: AppComponent

    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        (DaggerAppComponent.builder().build().viewModelFactory())
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment()

        coreComponent = (application as MainApplication).coreComponent
        component = DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
        component.inject(this)
    }

    private fun setFragment() {
        val firstFragment = FeatureAFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, firstFragment)
        fragmentTransaction.commit()
    }

}