package com.mobile.impraise

import com.mobile.impraise.models.Feedback
import javax.inject.Inject

/**
 * Created by aftab on 2017-11-19.
 */
class MainPresenterImpl
@Inject constructor(private val view: MainContract.View, private val feedback: Feedback) : MainContract.Presenter {

    override fun attach() {
        feedback.users?.isNotEmpty().let {
            view.displayData(feedback)
        }
    }

    override fun detach() {

    }
}