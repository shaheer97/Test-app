package com.example.test

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.adapters.ViewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val adapter = ViewpagerAdapter(supportFragmentManager, lifecycle)

        view_pager.adapter = adapter





        tabLayout.addTab(tabLayout.newTab().setText("All"))
        tabLayout.addTab(tabLayout.newTab().setText("Specifics"))

        view_pager.setCurrentItem(tabLayout.selectedTabPosition)

         TabLayoutMediator(tabLayout,view_pager){tab,position->
             when (position){

                 0->{
                     tab.text="All"
                 }
                 1->{
                     tab.text="Specifics"

                 }
             }
         }.attach()

    }


}