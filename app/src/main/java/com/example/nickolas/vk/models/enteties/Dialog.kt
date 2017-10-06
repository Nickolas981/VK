package com.example.nickolas.vk.models.enteties

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Dialog {

    @SerializedName("unread")
    @Expose
    var unread: Int? = null
        get() = if (field == null) 0 else field
    @SerializedName("message")
    @Expose
    var message: Message? = null
    @SerializedName("in_read")
    @Expose
    var inRead: Int? = null
    @SerializedName("out_read")
    @Expose
    var outRead: Int? = null

}