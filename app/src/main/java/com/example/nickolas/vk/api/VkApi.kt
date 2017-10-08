package com.example.nickolas.vk.api

import com.vk.sdk.VKSdk
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


interface VkApi {

    @GET("newsfeed.get")
    fun getFeed(@Query("filters") filters: String
                , @Query("start_from") startFrom: Int
                , @Query("count") count: Int)
            : Observable<ResponseBody>


    @GET("messages.getDialogs")
    fun getDialogs(@Query("offset") offset: Int
                   , @Query("access_token") token: String = VKSdk.getAccessToken().accessToken
                   , @Query("v") version: String = "5.68")
            : Observable<ResponseBody>

    @GET("users.get")
    fun usersGet(@Query("user_ids") usersID: String
                 , @Query("fields") fields: String = "photo_50, photo_400_orig ,online")
            : Observable<ResponseBody>

    @GET("messages.getHistory")
    fun getHistory(@Query("offset") offset: Int
                   , @Query("peer_id") id: Int
                   , @Query("access_token") token: String = VKSdk.getAccessToken().accessToken)
            : Observable<ResponseBody>

}
