package com.mobile.impraise.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.mobile.impraise.BaseContentViewHolder
import com.mobile.impraise.R
import com.mobile.impraise.models.BaseContentModel
import com.mobile.impraise.models.FeedbackCardContentModel
import com.squareup.picasso.Picasso

/**
 * Created by aftab on 2017-11-19.
 */
class FeedCardViewHolder(itemView: View) : BaseContentViewHolder(itemView) {

    @BindView(R.id.image_view)
    lateinit var userImage: ImageView

    @BindView(R.id.user_name_label)
    lateinit var usernameLabel: TextView

    @BindView(R.id.feedback_label)
    lateinit var lastFeedbackDateLabel: TextView

    @BindView(R.id.give_feedback_label)
    lateinit var giveFeedbackLabel: TextView

    override fun onBind(contentModel: BaseContentModel) {
        if (contentModel is FeedbackCardContentModel) {
            if (contentModel.image.isNotEmpty()) {
                Picasso.with(itemView.context)
                        .load(contentModel.image)
                        .into(userImage)
            }

            usernameLabel.text = contentModel.name

            if (contentModel.lastFeedbackDate.isNotEmpty()) {
                lastFeedbackDateLabel.text = itemView.context.getString(R.string.last_feedback_date, contentModel.lastFeedbackDate)
            } else {
                lastFeedbackDateLabel.text = itemView.context.getString(R.string.no_feedback_given)
            }
        }
    }
}