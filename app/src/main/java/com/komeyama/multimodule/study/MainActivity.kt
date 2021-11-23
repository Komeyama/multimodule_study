package com.komeyama.multimodule.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komeyama.multimodule.study.di.DaggerAppComponent
import com.komeyama.multimodule.study.feature_a.FeatureAFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment()

        val coreComponent = (application as MainApplication).coreComponent
        val component = DaggerAppComponent
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