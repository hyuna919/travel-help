package com.example.travel_help

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRvAdapter(val context:Context, val countryList: ArrayList<DataClassCountry>):
    RecyclerView.Adapter<MainRvAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_main, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(countryList[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val countryList = itemView?.findViewById<TextView>(R.id.tv_countryList)
        fun bind(country: DataClassCountry, context: Context) {
            countryList?.text = country.countryName
        }
    }

}