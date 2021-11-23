package com.komeyama.multimodule.study.usecase_a.internal

import android.util.Log
import com.komeyama.multimodule.study.usecase_a.UseCaseA

internal class UseCaseAImpl: UseCaseA {
    override fun serviceA1() {
        Log.d("usecase", "call serviceA1")
    }
}