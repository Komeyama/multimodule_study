package com.komeyama.multimodule.study.feature_a

import androidx.lifecycle.ViewModel
import com.komeyama.multimodule.study.usecase_a.UseCaseA
import javax.inject.Inject

class FeatureAViewModel @Inject constructor(
    private val useCaseA: UseCaseA
) : ViewModel() {
    fun serviceA1() = useCaseA.serviceA1()
}