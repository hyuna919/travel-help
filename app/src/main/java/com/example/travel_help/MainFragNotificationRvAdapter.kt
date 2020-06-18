package com.example.travel_help

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainFragNotificationRvAdapter(val context:Context, val notiList: ArrayList<DataClassNoti>, val itemClick: (DataClassNoti) -> Unit):
    RecyclerView.Adapter<MainFragNotificationRvAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_frag_noti_rv, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return notiList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(notiList[position], context)
    }

    inner class Holder(itemView: View?, itemClick:(DataClassNoti)->Unit) : RecyclerView.ViewHolder(itemView!!) {
        val list = itemView?.findViewById<TextView>(R.id.noti_rv_item)
        fun bind(noti: DataClassNoti, context: Context) {
            list?.text = noti.title

            itemView.setOnClickListener{itemClick(noti)}
        }
    }

}