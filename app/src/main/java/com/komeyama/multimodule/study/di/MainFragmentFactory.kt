package com.komeyama.multimodule.study.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class MainFragmentFactory @Inject constructor(
    private val providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val found = providers.entries.find { className == it.key.name }
            ?: throw IllegalArgumentException("unknown model class $className")

        val provider = found.value

        @Suppress("UNCHECKED_CAST")
        return provider.get()
    }
}