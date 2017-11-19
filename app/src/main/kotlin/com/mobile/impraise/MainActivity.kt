package com.mobile.impraise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mobile.impraise.models.Feedback

/**
 * Created by aftab on 2017-11-16.
 */

class MainActivity : AppCompatActivity(), MainContract.View {

    private val tag = MainActivity::class.java.name
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenterImpl(this, assets.open("feedback.json"))
        presenter.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun displayData(feedback: Feedback) {
        Log.d(tag, "feedback data is: " + feedback)
    }

    override fun displayError() {
        Log.e(tag, "Error. No data available")
    }
}