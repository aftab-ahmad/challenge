package com.mobile.impraise

import android.text.format.DateUtils
import android.util.Log
import com.mobile.impraise.models.BaseContentModel
import com.mobile.impraise.models.Feedback
import com.mobile.impraise.models.FeedbackCardContentModel
import com.mobile.impraise.models.TitleContentModel
import org.joda.time.DateTime
import org.joda.time.Weeks
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * Created by aftab on 2017-11-19.
 */
class MainPresenterImpl
@Inject constructor(private val view: MainContract.View, private val feedback: Feedback) : MainContract.Presenter {

    private val twoWeeks = 2

    override fun attach() {
        feedback.users?.isNotEmpty().let {

            val itemList = ArrayList<BaseContentModel>()
            val giveFeedbackList = ArrayList<BaseContentModel>()
            val gaveFeedbackList = ArrayList<BaseContentModel>()

            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.CANADA)

            val now = DateTime()
            val calendar = Calendar.getInstance()

            feedback.users?.forEach { user ->
                if (user.lastInteractions?.isEmpty() == true) {
                    giveFeedbackList.add(FeedbackCardContentModel(user.name ?: "", user.avatar ?: "", ""))
                    Log.d("TAG", "no interaction for: " + user.name)
                } else {
                    val firstItem = user.lastInteractions?.get(0)

                    firstItem?.let {
                        calendar.time = dateFormat.parse(it.date)
                        val lastInteractionDate = DateTime(calendar.time)
                        val date = DateUtils.getRelativeTimeSpanString(calendar.timeInMillis, DateTime().millis, 0L) as String

                        if (isMoreThanTwoWeeksBetweenDates(now, lastInteractionDate)) {
                            gaveFeedbackList.add(FeedbackCardContentModel(user.name ?: "", user.avatar ?: "", date))
                        } else {
                            giveFeedbackList.add(FeedbackCardContentModel(user.name ?: "", user.avatar ?: "", date))
                        }
                    }
                }
            }

            if (giveFeedbackList.isNotEmpty()) {
                itemList.add(TitleContentModel("Give Feedback"))
                itemList.addAll(giveFeedbackList)
            }

            if (gaveFeedbackList.isNotEmpty()) {
                itemList.add(TitleContentModel("Given Feedback"))
                itemList.addAll(gaveFeedbackList)
            }

            view.displayData(itemList)
        }
    }

    override fun detach() {

    }

    private fun isMoreThanTwoWeeksBetweenDates(now: DateTime, lastInteractionDate: DateTime): Boolean =
            Weeks.weeksBetween(lastInteractionDate, now).weeks > twoWeeks
}