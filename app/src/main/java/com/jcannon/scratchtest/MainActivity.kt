package com.jcannon.scratchtest

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentFrag : String = ""

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HelloFragment(), currentFrag)
                        .commit()

                currentFrag = "HelloFragment"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MiddleFragment(), currentFrag)
                        .commit()

                currentFrag = "MiddleFragment"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, RightFragment(), currentFrag)
                        .commit()

                currentFrag = "RightFragment"
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, HelloFragment())
                .commit()
    }
}


