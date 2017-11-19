package com.mobile.impraise.dagger

import com.mobile.impraise.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by aftab on 2017-11-19.
 */
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = arrayOf(MainPresenterModule::class))

    abstract fun mainActivityInjector(): MainActivity
}