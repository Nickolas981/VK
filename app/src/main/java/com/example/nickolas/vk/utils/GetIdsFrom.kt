package com.example.nickolas.vk.utils

import com.example.nickolas.vk.models.enteties.Dialog


class GetIdsFrom {

    companion object {
        fun dialogList(dialogs: List<Dialog>): String {
            var res = ""
            for (dialog in dialogs) {
                if (dialog.message!!.title == "" && dialog.message!!.userId!! > 0) {
                    res += ", " + Integer.toString(dialog.message!!.userId!!)
                }
            }
            return res
        }
    }

}
