package com.cuesoft.io.apparule.views

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.cuesoft.io.apparule.R

class BaseActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
         /*   R.id.navigation_favourite -> {

                return@OnNavigationItemSelectedListener true
            }*/
            R.id.navigation_search -> {

                return@OnNavigationItemSelectedListener true
            }
          /*  R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }*/

            /*R.id.navigation_add ->{
                return@OnNavigationItemSelectedListener  true
            }*/

            R.id.navigation_account->{
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //navView.

        //textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


       navView.setBackgroundColor(resources.getColor( R.color.LightBlue))

    }
}
