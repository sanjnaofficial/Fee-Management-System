package com.example.feesmanagementsystem

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.feesmanagementsystem.Models.student_viewPager
import com.google.android.material.tabs.TabLayout

class StudentProfile : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    var viewPagerAdapter: student_viewPager?=null

    lateinit var frag3: Fragment
    companion object {
        var emailComp :String? = ""
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)

        viewPager = findViewById(R.id.student_swipe)
        tabLayout = findViewById(R.id.student_tabs)

       val e =  intent.getStringExtra("emailTxt")

        emailComp = e

        val bundle = Bundle()
        bundle.putString("em",e)
        frag3 = Home3()
        frag3.arguments= bundle



        viewPagerAdapter = student_viewPager(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        tabLayout.setupWithViewPager(viewPager)
    }

}