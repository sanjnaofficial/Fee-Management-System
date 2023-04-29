package com.example.feesmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
// login page for admin
class LoginPage2 : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var passwd: EditText
    lateinit var loginbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page2)

        supportActionBar?.setTitle("Login")
        email= findViewById(R.id.email)
        passwd= findViewById(R.id.password)
        loginbtn=findViewById(R.id.btn_login)

        loginbtn.setOnClickListener {

            if(email.text.isEmpty() || passwd.text.isEmpty()){
                Toast.makeText(this,"Enter both the fields", Toast.LENGTH_LONG).show()
            }
            else if(email.text.toString()=="admin@lpu.in" && passwd.text.toString()=="1234"){
                intent = Intent(this,FrameMain::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Enter correct credentials", Toast.LENGTH_LONG).show()
            }

        }
    }
}