package com.example.nickolas.vk.models.enteties

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("photo_50")
    @Expose
    var photo50: String? = null
    @SerializedName("photo_400_orig")
    @Expose
    var photo400Orig: String? = null
    @SerializedName("online")
    @Expose
    var online: Int? = null

    fun getFullName(): String = firstName + " " + lastName

}
