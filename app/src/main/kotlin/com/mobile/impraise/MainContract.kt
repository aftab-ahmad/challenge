package com.mobile.impraise

import com.mobile.impraise.models.Feedback

/**
 * Created by aftab on 2017-11-19.
 */
interface MainContract {

    interface View {
        fun displayData(feedback: Feedback)
        fun displayError()
    }

    interface Presenter {
        fun attach()
        fun detach()
    }
}