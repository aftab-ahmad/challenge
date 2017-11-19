package com.mobile.impraise

import android.os.Bundle
import android.util.Log
import com.mobile.impraise.models.Feedback
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by aftab on 2017-11-16.
 */

class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    private val tag = MainActivity::class.java.name

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        presenter.attach()
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun displayData(feedback: Feedback) {
        Log.d(tag, "feedback data is: " + feedback)
    }

    override fun displayError() {
        Log.e(tag, "Error. No data available")
    }
}