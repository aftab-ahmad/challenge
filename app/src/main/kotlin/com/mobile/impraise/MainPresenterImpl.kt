package com.mobile.impraise

import com.google.gson.Gson
import com.mobile.impraise.models.Feedback
import java.io.IOException
import java.io.InputStream

/**
 * Created by aftab on 2017-11-19.
 */
class MainPresenterImpl(private val view: MainContract.View,
                        private val inputStream: InputStream) : MainContract.Presenter {

    override fun attach() {
        val response = readStream()

        if (response.isNotEmpty()) {
            val feedbackData = Gson().fromJson(response, Feedback::class.java)

            feedbackData?.users?.isNotEmpty()?.let {
                view.displayData(feedbackData)
            } ?: view.displayError()
        } else {
            view.displayError()
        }
    }

    override fun detach() {

    }

    private fun readStream(): String {
        return try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (error: IOException) {
            ""
        }
    }
}