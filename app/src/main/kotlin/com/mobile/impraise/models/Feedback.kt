package com.mobile.impraise.models

import com.google.gson.annotations.SerializedName

/**
 * Created by aftab on 2017-11-19.
 */

data class Feedback (
		val users: List<User>?
)

data class User(
		val id: Int, //1
		val name: String?, //John Doe
		val email: String?, //john@feedback.com
		val avatar: String?, //https://s3.amazonaws.com/uifaces/faces/twitter/sauro/128.jpg

		@SerializedName("last_interactions")
		val lastInteractions: List<LastInteraction>?
)

data class LastInteraction(
		val id: Int, //1
		val date: String //2017-04-22T07:10:59Z
)