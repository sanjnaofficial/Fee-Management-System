package com.example.feesmanagementsystem.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feesmanagementsystem.Models.User
import com.example.feesmanagementsystem.R

class MyAdapter(private val userList: ArrayList<User>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(clickListener: onItemClickListener){
        mListener= clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,false
        )
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = userList[position]

        holder.nameTxt.text = currentitem.nameTxt
        holder.regTxt.text = currentitem.regTxt
        holder.emailTxt.text = currentitem.emailTxt
        holder.phoneTxt.text= currentitem.phoneTxt
        holder.totalFee.text=currentitem.totalFee
        holder.pendingFee.text= currentitem.pendingFee
    }

    override fun getItemCount(): Int {
        return userList.size
    }

//    fun updateUserList(userList : List<User>){
//
//        this.userList.clear()
//        this.userList.addAll(userList)
//        notifyDataSetChanged()
//
//    }

    class MyViewHolder(itemView: View, clickListener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val nameTxt: TextView = itemView.findViewById(R.id.tvname)
        val regTxt: TextView= itemView.findViewById(R.id.tvreg)
        val emailTxt: TextView= itemView.findViewById(R.id.tvemail)
        val phoneTxt: TextView= itemView.findViewById(R.id.tvphone)
        val totalFee: TextView= itemView.findViewById(R.id.tvfees)
        val pendingFee: TextView= itemView.findViewById(R.id.tvpend)

        init{
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }
}