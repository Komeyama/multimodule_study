package com.komeyama.multimodule.study.db_a.internal

import android.content.Context
import com.komeyama.multimodule.study.db_a.DataBaseA
import dagger.Module
import dagger.Provides
import timber.log.Timber

internal class DataBaseAImpl constructor(private val context: Context) : DataBaseA {
    override fun info(): List<String> {
        val sharedPreference = context.getSharedPreferences("store_a", Context.MODE_PRIVATE)
        Timber.d("DataBaseA's SharedPreferences: $sharedPreference")
        return listOf("info#1", "info#2", "info#3")
    }
}

@Module
class DataBaseAModule {

    @Provides
    fun provideDataBase(context: Context): DataBaseA {
        return DataBaseAImpl(context)
    }
}