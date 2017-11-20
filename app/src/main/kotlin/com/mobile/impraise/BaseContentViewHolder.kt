package com.mobile.impraise

import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.ButterKnife
import com.mobile.impraise.models.BaseContentModel

/**
 * Created by aftab on 2017-11-19.
 */
abstract class BaseContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        ButterKnife.bind(this, itemView)
    }

    abstract fun onBind(contentModel: BaseContentModel)
}