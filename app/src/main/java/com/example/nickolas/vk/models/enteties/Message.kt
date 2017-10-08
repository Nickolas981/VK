package com.example.nickolas.vk.models.enteties

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Message {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("date")
    @Expose
    var date: Long? = null
    @SerializedName("out")
    @Expose
    var out: Int? = null
    @SerializedName("user_id")
    @Expose
    var userId: Int? = null
    @SerializedName("read_state")
    @Expose
    var readState: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null
    @SerializedName("emoji")
    @Expose
    var emoji: Int? = null
    @SerializedName("chat_id")
    @Expose
    var chatId: Int? = null
    @SerializedName("chat_active")
    @Expose
    var chatActive: List<Int>? = null
    @SerializedName("users_count")
    @Expose
    var usersCount: Int? = null
    @SerializedName("admin_id")
    @Expose
    var adminId: Int? = null
    @SerializedName("random_id")
    @Expose
    var randomId: Int? = null
    @SerializedName("photo_50")
    @Expose
    var photo50: String? = null
    @SerializedName("photo_100")
    @Expose
    var photo100: String? = null
    @SerializedName("photo_200")
    @Expose
    var photo200: String? = null
    var user: User? = null
}
