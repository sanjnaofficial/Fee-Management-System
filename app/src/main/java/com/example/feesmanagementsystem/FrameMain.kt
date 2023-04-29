package com.example.feesmanagementsystem

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feesmanagementsystem.Adapter.MyAdapter
import com.example.feesmanagementsystem.Models.User
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class FrameMain : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var emplist: ArrayList<User>
    private lateinit var dbRef: DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        emplist = arrayListOf<User>()

        getData()

      supportActionBar?.setTitle("Student Details")
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getData() {
    dbRef= FirebaseDatabase.getInstance().getReference("Registered Users")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                emplist.clear()
                if(snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(User::class.java)
                        emplist.add(empData!!)
                    }
                    val mAdapter = MyAdapter(emplist)
                    recyclerView.adapter = mAdapter

                    mAdapter.setOnClickListener(object : MyAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
//                            emplist[position].pendingFee = intent.getStringExtra("pendTxt")

                            val intent = Intent(this@FrameMain, ListOfStudents::class.java)
                            intent.putExtra("nameTxt", emplist[position].nameTxt)
                            intent.putExtra("regTxt", emplist[position].regTxt)
                            intent.putExtra("emailTxt", emplist[position].emailTxt)
                            intent.putExtra("phoneTxt", emplist[position].phoneTxt)
                            intent.putExtra("totalTxt", emplist[position].totalFee)
                            intent.putExtra("pendTxt", emplist[position].pendingFee)
                            startActivity(intent)

                        }

                    })
                    recyclerView.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}