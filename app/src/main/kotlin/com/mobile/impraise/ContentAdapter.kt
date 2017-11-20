package com.mobile.impraise

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.impraise.models.BaseContentModel
import com.mobile.impraise.models.FeedbackCardContentModel
import com.mobile.impraise.models.TitleContentModel
import com.mobile.impraise.viewHolders.FeedCardViewHolder
import com.mobile.impraise.viewHolders.TitleViewHolder

/**
 * Created by aftab on 2017-11-19.
 */
class ContentAdapter(private val itemList: List<BaseContentModel>) : RecyclerView.Adapter<BaseContentViewHolder>() {

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: BaseContentViewHolder?, position: Int) {
        holder?.onBind(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseContentViewHolder {
        val view: View
        val inflater = LayoutInflater.from(parent?.context)

        return when (viewType) {
            TitleContentModel.type -> {
                view = inflater.inflate(R.layout.title_item_view, parent, false)
                TitleViewHolder(view)
            }
            FeedbackCardContentModel.type -> {
                view = inflater.inflate(R.layout.feedback_item_view, parent, false)
                FeedCardViewHolder(view)
            }
            else -> {
                view = inflater.inflate(R.layout.title_item_view, parent, false)
                TitleViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = itemList[position].itemViewType()
}