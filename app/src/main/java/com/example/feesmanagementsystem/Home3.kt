package com.example.feesmanagementsystem

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import android.graphics.Color
import com.example.feesmanagementsystem.StudentProfile.Companion.emailComp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter


class Home3 : Fragment() {
    var email: String? = ""
    lateinit var emailtxt: TextView
    lateinit var database: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view= inflater.inflate(R.layout.fragment_home3, container, false)

        email = emailComp

        emailtxt = view.findViewById(R.id.emailTV)
        emailtxt.setText(email)

//        readdata(email)
        return view
    }

//    private fun readdata(email: String?) {
//
//        database = FirebaseDatabase.getInstance().getReference("Registered Users")
//        if (email != null) {
//            database.child(email).get().addOnSuccessListener{
//
//                val emailTxt = database.child("emailTxt").value
//                val nameTxt = database.child("nameTxt").value
//                val pendingFee = database.child("pendingFees").value
//                val phoneTxt = database.child("phoneTxt").value
//                val regTxt = database.child("regTxt").value
//                val totalFee = database.child("totalFees").values
//
//                var show_name = view.findViewById<TextView>(R.id.nameTV)
//                show_name.setText("nameTxt")
//            }
//        }
//    }

}