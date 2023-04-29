package com.example.feesmanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feesmanagementsystem.databinding.ActivityReadDataBinding
import com.google.firebase.database.DatabaseReference

class ReadData : AppCompatActivity() {
    private lateinit var binding: ActivityReadDataBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_data)
    }
}