package com.mobile.impraise.viewHolders

import android.text.format.DateUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.mobile.impraise.BaseContentViewHolder
import com.mobile.impraise.R
import com.mobile.impraise.models.BaseContentModel
import com.mobile.impraise.models.FeedbackCardContentModel
import com.squareup.picasso.Picasso
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*

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
                val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.CANADA)

                val calendar = Calendar.getInstance()
                calendar.time = dateFormat.parse(contentModel.lastFeedbackDate)

                val date = DateUtils.getRelativeTimeSpanString(calendar.timeInMillis, DateTime().millis, 0L)
                lastFeedbackDateLabel.text = date
            } else {
                lastFeedbackDateLabel.text = "No feedback given"
            }
        }
    }
}