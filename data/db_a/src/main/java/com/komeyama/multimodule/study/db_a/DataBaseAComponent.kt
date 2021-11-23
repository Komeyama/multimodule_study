package com.komeyama.multimodule.study.db_a

import android.content.Context
import com.komeyama.multimodule.study.db_a.internal.DataBaseAModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataBaseAModule::class]
)
interface DataBaseAComponent {
    fun dataBaseA(): DataBaseA

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): DataBaseAComponent
    }

    companion object {
        fun factory(): Factory = DaggerDataBaseAComponent.factory()
    }
}