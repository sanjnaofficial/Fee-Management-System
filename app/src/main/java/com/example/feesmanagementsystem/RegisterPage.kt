package com.example.feesmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class RegisterPage : AppCompatActivity() {

    lateinit var etname:EditText
    lateinit var etreg:EditText
    lateinit var etphone:EditText
    lateinit var etEmail:EditText
    lateinit var etPassword: EditText
    lateinit var btnReg: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        etname= findViewById(R.id.name)
        etreg=findViewById(R.id.regNo)
        etphone=findViewById(R.id.PhoneNo)
        etEmail = findViewById(R.id.email)
        etPassword = findViewById(R.id.password)
        btnReg = findViewById(R.id.btn_register)

        var nameTxt= etname.text
        var regTxt= etreg.text
        var phoneTxt= etphone.text
        var emailTxt= etEmail.text
        var passTxt= etPassword.text

        var totalFee = 10000
        var pendingFee = 2000

        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        btnReg.setOnClickListener {
            if(nameTxt.isEmpty() || regTxt.isEmpty() || phoneTxt.isEmpty() || emailTxt.isEmpty() || passTxt.isEmpty()){
                Toast.makeText(this,"Please fill all the details", Toast.LENGTH_LONG).show()
            }
            else if(!emailTxt.matches(emailRegex.toRegex())){
                Toast.makeText(this,"Enter Valid Email Address", Toast.LENGTH_LONG).show()
            }
            else if(phoneTxt.length!=10){
                Toast.makeText(this,"Enter Valid Phone Number", Toast.LENGTH_LONG).show()
            }
            else if(passTxt.length<6){
                Toast.makeText(this,"Password cannot be less than 6 digit", Toast.LENGTH_LONG).show()
            }
            else {
                registerUser(nameTxt.toString(),regTxt.toString(), phoneTxt.toString(), emailTxt.toString(), passTxt.toString(), totalFee, pendingFee)
                Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun registerUser(nameTxt: String, regTxt: String, phoneTxt: String, emailTxt: String, passTxt: String, totalFee:Int, pendingFee:Int) {
        var auth: FirebaseAuth= FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(emailTxt,passTxt).addOnCompleteListener(this){ task->
            if (task.isSuccessful) {

                val firebaseuser: FirebaseUser?= auth.currentUser

                val writeUserDetails = ReadWriteUserDetails(nameTxt, regTxt, phoneTxt, emailTxt, passTxt, totalFee.toString(), pendingFee.toString())

                // Use the email address as the key for the user's data
                var referenceProfile: DatabaseReference = FirebaseDatabase.getInstance().getReference("Registered Users")
                    .child(emailTxt.replace(".", ","))

                referenceProfile.setValue(writeUserDetails).addOnCompleteListener(this) { task ->
                    if(task.isSuccessful){
                        if (firebaseuser != null) {
                            firebaseuser.sendEmailVerification()
                            Toast.makeText(this, "User Successfully Created. Kindly verify your email.",
                                Toast.LENGTH_SHORT).show()

                            intent = Intent(this,StudentProfile::class.java)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        Toast.makeText(this, "User Registration Failed. Try Again",
                            Toast.LENGTH_SHORT).show()
                    }
                }

            } else {
                try{
                    throw task.getException()!!
                }catch (e: FirebaseAuthUserCollisionException){
                    etPassword.setError("User is already registered with this mail")
                    etPassword.requestFocus()
                }
                Toast.makeText(this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private fun registerUser(nameTxt: String, regTxt: String, phoneTxt: String, emailTxt: String, passTxt: String, totalFee:Int, pendingFee:Int) {
//        var auth: FirebaseAuth= FirebaseAuth.getInstance()
//        auth.createUserWithEmailAndPassword(emailTxt,passTxt).addOnCompleteListener(this){ task->
//            if (task.isSuccessful) {
//
//                val firebaseuser: FirebaseUser?= auth.currentUser
//
////                var profileChangeRequest: UserProfileChangeRequest= UserProfileChangeRequest.Builder().setDisplayName(nameTxt).builder()
////                firebaseuser?.updateProfile(profileChangeRequest)
//
//
//                    val writeUserDetails = ReadWriteUserDetails(nameTxt, regTxt, phoneTxt, emailTxt, passTxt, totalFee.toString(), pendingFee.toString())
//
//                    var referenceProfile: DatabaseReference = FirebaseDatabase.getInstance().getReference("Registered Users")
//
//                if (firebaseuser != null) {
//                    referenceProfile.child(firebaseuser.uid).setValue(writeUserDetails).addOnCompleteListener(this) { task ->
//
//
//                    if(task.isSuccessful){
//                        if (firebaseuser != null) {
//                            firebaseuser.sendEmailVerification()
//                            Toast.makeText(this, "User Successfully Created. Kindly verify your email.",
//                                Toast.LENGTH_SHORT).show()
//
//                            intent = Intent(this,StudentProfile::class.java)
//                            //                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                            //                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                            //                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//
//                            startActivity(intent)
//                            finish()
//                        }
//                    }
//                        else{
//                        Toast.makeText(this, "User Registration Failed. Try Again",
//                            Toast.LENGTH_SHORT).show()
//                    }
//
//                    }
//                }
//
//
//            } else {
//                try{
//                    throw task.getException()!!
//                }catch (e: FirebaseAuthUserCollisionException){
//                    etPassword.setError("User is already registered with this mail")
//                    etPassword.requestFocus()
//                }
//                Toast.makeText(this, "Authentication failed.",
//                    Toast.LENGTH_SHORT).show()
//            }
//
//        }
//    }
}