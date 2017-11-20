package com.mobile.impraise.models

/**
 * Created by aftab on 2017-11-19.
 */
data class FeedbackCardContentModel(val name: String,
                                    val image: String,
                                    val lastFeedbackDate: String) : BaseContentModel() {

    companion object {
        val type = 1
    }

    override fun itemViewType() : Int = type
}