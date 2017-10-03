package com.example.nickolas.vk.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface VkApi {

    @GET("newsfeed.get")
    Observable<ResponseBody> getFeed(@Query("filters") String filters
            , @Query("start_from") int startFrom
            , @Query("count") int count);


    @GET("messages.getDialogs")
    Observable<ResponseBody> getDialogs(@Query("count") int count
            , @Query("offset") int offset
            , @Query("access_token") String tokken);

}
