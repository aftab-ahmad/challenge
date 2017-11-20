package com.mobile.impraise.viewHolders

import android.view.View
import android.widget.TextView
import butterknife.BindView
import com.mobile.impraise.BaseContentViewHolder
import com.mobile.impraise.R
import com.mobile.impraise.models.BaseContentModel
import com.mobile.impraise.models.TitleContentModel

/**
 * Created by aftab on 2017-11-19.
 */
class TitleViewHolder(itemView: View) : BaseContentViewHolder(itemView) {

    @BindView(R.id.title_label)
    lateinit var titleLabel: TextView

    override fun onBind(contentModel: BaseContentModel) {
        if (contentModel is TitleContentModel) {
            titleLabel.text = contentModel.title
        }
    }
}