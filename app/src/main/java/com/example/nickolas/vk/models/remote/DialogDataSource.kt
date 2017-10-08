package com.example.nickolas.vk.models.remote

import com.example.nickolas.vk.api.VkApi
import okhttp3.ResponseBody
import rx.Observable

/**
 * Created by Nickolas on 08.10.2017.
 */

class DialogDataSource(private val api: VkApi) : IDialogDataSource {
    override fun getHistory(offset: Int, id: Int): Observable<ResponseBody>
            = api.getHistory(offset, id)
}

