package com.example.nickolas.vk.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Nickolas on 01.10.2017.
 */

public interface VkApi {

    @GET("newsfeed.get")
    Observable<ResponseBody> getFeed(@Query("filters") String filters
            , @Query("start_from") int startFrom
            , @Query("count") int count);


    @GET("messages.GetDialogs")
    Observable<ResponseBody> getDialogs(@Query("offset") int offset
    , @Query("count") int count);

}
