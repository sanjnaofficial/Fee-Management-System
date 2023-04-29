package com.example.feesmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.feesmanagementsystem.databinding.ActivityReadDataBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

// login page for students
class LoginPage : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var passwd: EditText
    lateinit var loginbtn: Button
    lateinit var registerNow:Button
    lateinit var authProfile: FirebaseAuth

    private lateinit var binding: ActivityReadDataBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        supportActionBar?.setTitle("Login")

        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        email= findViewById(R.id.email)
        passwd= findViewById(R.id.password)
        loginbtn=findViewById(R.id.btn_login)
        registerNow= findViewById(R.id.register_now)

        authProfile= FirebaseAuth.getInstance()

        loginbtn.setOnClickListener {

            var emailTxt= email.text
            var passwdTxt= passwd.text

            if(emailTxt.isEmpty() || passwdTxt.isEmpty()){
                Toast.makeText(this, "Enter both the fields", Toast.LENGTH_LONG).show()
            }  else if(!emailTxt.matches(emailRegex.toRegex())){
                Toast.makeText(this,"Enter Valid Email Address", Toast.LENGTH_LONG).show()
            }
            else{
            loginUser(emailTxt.toString(), passwdTxt.toString())
            }

        }

        registerNow.setOnClickListener {
            intent = Intent(this,RegisterPage::class.java)
            intent.putExtra("id",1)
            startActivity(intent)
        }

    }

    private fun loginUser(emailTxt: String, passwdTxt: String) {
        authProfile.signInWithEmailAndPassword(emailTxt,passwdTxt).addOnCompleteListener(this) { task->
            if(task.isSuccessful){
                binding = ActivityReadDataBinding.inflate(layoutInflater)
                setContentView(binding.root)

                
                Toast.makeText(this,"User has logged in Successfully", Toast.LENGTH_LONG).show()
                intent = Intent(this,StudentProfile::class.java)
                intent.putExtra("emailTxt", emailTxt)

//                val bundle = Bundle()
//
//                bundle.putString("emailTxt", emailTxt)
                startActivity(intent)
            } else{
                Toast.makeText(this,"Login Unsuccessfully", Toast.LENGTH_LONG).show()

            }
        }
    }
}