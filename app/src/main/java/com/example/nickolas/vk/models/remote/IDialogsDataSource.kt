package com.example.nickolas.vk.models.remote

import com.example.nickolas.vk.models.enteties.Dialog

import okhttp3.ResponseBody
import rx.Observable

/**
 * Created by Nickolas on 01.10.2017.
 */

interface IDialogsDataSource {

    fun getDialogs(offset: Int, token: String): Observable<ResponseBody>
    fun getUsersData(dialogs: List<Dialog>): Observable<ResponseBody>

}
