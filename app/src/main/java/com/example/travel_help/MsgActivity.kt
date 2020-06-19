package com.example.travel_help

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.msg_send.*

class MsgActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.msg_send)

        val sender = intent.getStringExtra("sender")

        msg_send_sender.setText(sender)
    }
}