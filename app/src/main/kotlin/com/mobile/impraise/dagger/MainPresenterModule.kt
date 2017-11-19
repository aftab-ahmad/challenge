package com.mobile.impraise.dagger

import android.content.Context
import com.google.gson.Gson
import com.mobile.impraise.MainActivity
import com.mobile.impraise.MainContract
import com.mobile.impraise.MainPresenterImpl
import com.mobile.impraise.models.Feedback
import dagger.Binds
import dagger.Module
import dagger.Provides
import java.io.IOException

/**
 * Created by aftab on 2017-11-19.
 */

@Module
abstract class MainPresenterModule {

    @Binds
    abstract fun view(mainActivity: MainActivity): MainContract.View

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideHomePresenter(view: MainContract.View, context: Context): MainContract.Presenter {
            val inputStream = context.assets.open("feedback.json")

            var response = ""

            try {
                val bytes = ByteArray(inputStream.available())
                inputStream.read(bytes, 0, bytes.size)
                response = String(bytes)
            } catch (error: IOException) {

            }

            return MainPresenterImpl(view, Gson().fromJson(response, Feedback::class.java))
        }
    }
}