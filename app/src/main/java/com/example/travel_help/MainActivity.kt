package com.example.travel_help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_frag_home.*
import kotlinx.android.synthetic.main.main_frag_msg.*


class MainActivity: AppCompatActivity(), MainFragHome.OnFragmentInteractionListener,
    MainFragMessage.OnFragmentInteractionListener, MainFragMypage.OnFragmentInteractionListener, MainFragNotification.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_frame, MainFragHome()).commit()
            }
            R.id.navigation_massege -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_frame, MainFragMessage()).commit()
            }
            R.id.navigation_noti -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_frame, MainFragMypage()).commit()
            }
            R.id.navigation_mypage -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_frame, MainFragNotification()).commit()

            }
        }
        false
    }

    //리사이클러뷰 더미데이터
    val countryList = arrayListOf<DataClassCountry>(
        DataClassCountry("German"),
        DataClassCountry("France")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val navView: BottomNavigationView = findViewById(R.id.board_nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        supportFragmentManager.beginTransaction().replace(R.id.main_frame, MainFragHome()).commit()











    }
}
