package com.komeyama.multimodule.study.feature_a

import com.komeyama.multimodule.study.usecase_a.UseCaseA
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class FeatureAViewModelTest {

    lateinit var featureAViewModel: FeatureAViewModel
    lateinit var useCaseA: UseCaseA

    @Before
    fun setUp() {
        useCaseA = mockk(name = "MockUseCase")
        featureAViewModel = FeatureAViewModel(useCaseA)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun serviceA_called() {
        every { useCaseA.serviceA1() } returns Unit
        featureAViewModel.serviceA1()
        verify(exactly = 1) { useCaseA.serviceA1() }
    }
}