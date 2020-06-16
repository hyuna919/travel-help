package com.example.travel_help

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main.*


class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_massege -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_noti -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_setting -> {
                textMessage.setText(R.string.title_mypage)
                return@OnNavigationItemSelectedListener true
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
        val navView: BottomNavigationView = findViewById(R.id.main_nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        //리사이클러뷰 어댑터, 레이아웃매니저
        val mAdapter = MainRvAdapter(this, countryList)
        main_rv.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        main_rv.layoutManager = lm
        main_rv.setHasFixedSize(true)

        //임시 버튼 연결
        var boardCountry: String = "나라" //intent로 넘겨서 게시판종류 정할때 사용
        main_btn_board_Deutsch.setOnClickListener{
            val intent = Intent(this, BoardActivity::class.java)
            boardCountry="@string/Deutsch"
        }
        main_btn_board_France.setOnClickListener{
            boardCountry="@string/France"
        }





    }
}
