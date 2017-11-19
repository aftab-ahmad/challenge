package com.mobile.impraise.dagger

import android.content.Context
import com.mobile.impraise.ImpraiseApplication
import dagger.Binds
import dagger.Module

/**
 * Created by aftab on 2017-11-19.
 */
@Module
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: ImpraiseApplication): Context
}