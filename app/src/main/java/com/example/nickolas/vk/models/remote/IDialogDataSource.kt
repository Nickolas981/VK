package com.example.nickolas.vk.models.remote

import okhttp3.ResponseBody
import rx.Observable

/**
 * Created by Nickolas on 08.10.2017.
 */

interface IDialogDataSource {
    fun getHistory(offset: Int, id: Int): Observable<ResponseBody>
}
