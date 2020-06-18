package com.example.travel_help

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainFragMessageRvAdapter(val context:Context, val msgList: ArrayList<DataClassMsg>, val itemClick: (DataClassMsg) -> Unit):
    RecyclerView.Adapter<MainFragMessageRvAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_frag_msg_rv, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(msgList[position], context)
    }

    inner class Holder(itemView: View?, itemClick:(DataClassMsg)->Unit) : RecyclerView.ViewHolder(itemView!!) {
        val msgSender = itemView?.findViewById<TextView>(R.id.msg_rv_title)
        val msgContent = itemView?.findViewById<TextView>(R.id.msg_rv_content)
        fun bind(msg: DataClassMsg, context: Context) {
            msgSender?.text = msg.name
            msgContent?.text = msg.content

            itemView.setOnClickListener{itemClick(msg)}
        }
    }

}