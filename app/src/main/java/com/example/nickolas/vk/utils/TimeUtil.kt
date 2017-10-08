package com.example.nickolas.vk.utils

import java.text.SimpleDateFormat
import java.util.*


class TimeUtil {
    companion object {
        private fun clearTimes(c: Calendar): Calendar {
            c.set(Calendar.HOUR_OF_DAY, 0)
            c.set(Calendar.MINUTE, 0)
            c.set(Calendar.SECOND, 0)
            c.set(Calendar.MILLISECOND, 0)
            return c
        }

        fun convertSimpleDayFormat(time: Long): String {
            var today = Calendar.getInstance()
            today = clearTimes(today)

            var yesterday = Calendar.getInstance()
            yesterday.add(Calendar.DAY_OF_YEAR, -1)
            yesterday = clearTimes(yesterday)

            var last7days = Calendar.getInstance()
            last7days.add(Calendar.DAY_OF_YEAR, -7)
            last7days = clearTimes(last7days)

            var last30days = Calendar.getInstance()
            last30days.add(Calendar.DAY_OF_YEAR, -30)
            last30days = clearTimes(last30days)


            return when {
                time > today.timeInMillis -> "today"
                time > yesterday.timeInMillis -> "yesterday"
                time > last7days.timeInMillis -> "last7days"
                time > last30days.timeInMillis -> "last30days"
                else -> getDateFormat(time)
            }
        }

        private fun getDateFormat(c: Long): String {
            val date = Date(c * 1000)
            val sdf = SimpleDateFormat("dd-MMM")
            sdf.timeZone = TimeZone.getTimeZone("GMT-2")
            return sdf.format(date)
        }
    }
}