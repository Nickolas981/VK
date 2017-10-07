package com.example.nickolas.vk.utils

import com.example.nickolas.vk.models.enteties.Dialog
import okhttp3.ResponseBody


class JoinDataWith {

    companion object {
        fun dataWithDialogs(data: ResponseBody, dialogs: List<Dialog>): List<Dialog> {
            val users = ResponseToObjectUtil.parseToUserList(data)
            var counter = 0

            for (dialog in dialogs) with(dialog.message) {
                if (this?.title == "" && this.userId!! > 0) {
                    this.title = users[counter].getFullName()
                    this.photo50 = users[counter++].photo50
                }
            }
//            return Observable.just(dialogs)
            return dialogs
        }
    }

}
