package com.komeyama.multimodule.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komeyama.multimodule.study.feature_a.FeatureAFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FeatureAFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, firstFragment)
        fragmentTransaction.commit()
    }
}