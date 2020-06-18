package com.example.travel_help

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainFragMypageRvAdapter(val context:Context, val mypageList: ArrayList<DataClassMypage>, val itemClick: (DataClassMypage) -> Unit):
    RecyclerView.Adapter<MainFragMypageRvAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_frag_mypage_rv, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return mypageList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(mypageList[position], context)
    }

    inner class Holder(itemView: View?, itemClick:(DataClassMypage)->Unit) : RecyclerView.ViewHolder(itemView!!) {
        val list = itemView?.findViewById<TextView>(R.id.mypage_rv_item)
        fun bind(option: DataClassMypage, context: Context) {
            list?.text = option.list

            itemView.setOnClickListener{itemClick(option)}
        }
    }

}