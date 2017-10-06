package com.example.nickolas.vk.models.remote

import com.example.nickolas.vk.api.VkApi
import com.example.nickolas.vk.models.enteties.Dialog
import com.example.nickolas.vk.utils.GetIdsFrom

import okhttp3.ResponseBody
import rx.Observable


class DialogsDataSource(private val api: VkApi) : IDialogsDataSource {

    override fun getDialogs(offset: Int, token: String): Observable<ResponseBody>
            = api.getDialogs(offset, token)

    override fun getUsersData(dialogs: List<Dialog>): Observable<ResponseBody>
            = api.usersGet(GetIdsFrom.dialogList(dialogs))

}
