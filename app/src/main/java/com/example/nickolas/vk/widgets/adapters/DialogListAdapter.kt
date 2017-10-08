package com.example.nickolas.vk.widgets.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nickolas.vk.R
import com.example.nickolas.vk.activities.DialogActivity
import com.example.nickolas.vk.models.enteties.Dialog
import com.example.nickolas.vk.utils.TimeUtil
import kotlinx.android.synthetic.main.dialog_item_view.view.*
import java.util.*


class DialogListAdapter(private val context: Context) : RecyclerView.Adapter<DialogListAdapter.ViewHolder>() {
    private val dialogs: MutableList<Dialog>

    init {
        dialogs = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.dialog_item_view, parent, false)
        return ViewHolder(v)
    }

    fun addDialogs(dialogs: List<Dialog>?) {
        if (dialogs != null) this.dialogs.addAll(dialogs)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            lastMessage?.text = dialogs[position].message?.body
            countOfMessages?.visibility = if (dialogs[position].unread != 0) {
                countOfMessages?.text = dialogs[position].unread.toString()
                View.VISIBLE
            } else View.GONE
            name.text = dialogs[position].message?.title
            if (dialogs[position].message?.photo50 != null) {
                Glide.with(context)
                        .load(dialogs[position].message?.photo50).into(imageView)
            } else {
                imageView.setImageResource(R.drawable.gradient)
            }
            time.text = dialogs[position].message?.date
                    ?.let { TimeUtil.convertSimpleDayFormat(it) }
            item.setOnClickListener { dialogs[position].message?.userId?.let { it1 -> startAct(it1) } }
        }
    }

    fun startAct(id: Int) {
        var intent = Intent(context, DialogActivity::class.java)
        intent.putExtra("id", id)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int = dialogs.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countOfMessages = itemView.count_of_messages
        var imageView = itemView.dialogAvatarImage
        var name = itemView.user_name
        var lastMessage = itemView.last_message
        var time = itemView.last_message_time
        var item: View = itemView
    }
}

