package com.example.feesmanagementsystem

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.feesmanagementsystem.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference

class ListOfStudents : AppCompatActivity() {
    private  lateinit var  tvName: TextView
    private  lateinit var  tvReg: TextView
    private  lateinit var  tvEmail: TextView
    private  lateinit var  tvPhone: TextView
    private  lateinit var  tvTotal: TextView
    private  lateinit var  tvPend: TextView
    private lateinit var emailbtn: Button
    private lateinit var callbtn: Button

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_students)

        supportActionBar?.setTitle("Fees Details of Student")

        initView()

        var recipient = tvEmail.text.toString()

        var phoneNumber = tvPhone.text.toString()
        var pendFee = tvPend.text.toString()

        val subject= "Regarding Pending fee"
        val message = """Dear Student,
           Your fee is pending. Kindly Pay the """ +  pendFee  + """ Fee asap.
        """.trimMargin()

        setValuesToViews()

        emailbtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, recipient)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        }

        callbtn.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:$phoneNumber").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent)
        }

    }

    private fun initView() {
        tvName= findViewById(R.id.nameTV)
        tvEmail= findViewById(R.id.emailTV)
        tvPhone = findViewById<Button>(R.id.phoneTV)
        tvReg= findViewById(R.id.regTV)
        tvTotal= findViewById(R.id.feesTotalTV)
        tvPend= findViewById(R.id.feesPendingTV)

        emailbtn= findViewById(R.id.emailbtn)
        callbtn = findViewById(R.id.callbtn)
    }

    private fun setValuesToViews(){
        tvName.text = intent.getStringExtra("nameTxt")
        tvReg.text = intent.getStringExtra("regTxt")
        tvEmail.text = intent.getStringExtra("emailTxt")
        tvPhone.text = intent.getStringExtra("phoneTxt")
        tvTotal.text = intent.getStringExtra("totalTxt")
        tvPend.text = intent.getStringExtra("pendTxt")
    }
}