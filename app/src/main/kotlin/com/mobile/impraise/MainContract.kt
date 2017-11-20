package com.mobile.impraise

import com.mobile.impraise.models.BaseContentModel

/**
 * Created by aftab on 2017-11-19.
 */
interface MainContract {

    interface View {
        fun displayData(itemList: List<BaseContentModel>)
        fun displayError()
    }

    interface Presenter {
        fun attach()
        fun detach()
    }
}