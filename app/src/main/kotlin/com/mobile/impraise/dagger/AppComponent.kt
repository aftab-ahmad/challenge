package com.mobile.impraise.dagger

import com.mobile.impraise.ImpraiseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by aftab on 2017-11-19.
 */

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        MainActivityModule::class, AppModule::class))
interface AppComponent : AndroidInjector<ImpraiseApplication> {

    override fun inject(instance: ImpraiseApplication)


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: ImpraiseApplication): AppComponent.Builder

        fun build(): AppComponent
    }
}
