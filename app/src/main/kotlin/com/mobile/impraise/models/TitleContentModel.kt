package com.mobile.impraise.models

/**
 * Created by aftab on 2017-11-19.
 */
data class TitleContentModel(val title: String) : BaseContentModel() {

    companion object {
        val type = 2
    }

    override fun itemViewType(): Int = type
}