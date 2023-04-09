package com.example.hackerthon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(val context:Context,val itemList:ArrayList<govt_sign>):RecyclerView.Adapter<adapter.db>() {
    class db(view: View):RecyclerView.ViewHolder(view){

        val item=view.findViewById<TextView>(R.id.rec1)
        val use=view.findViewById<TextView>(R.id.rec2)
        val price=view.findViewById<TextView>(R.id.rec3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): db {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_name,parent,false)
        return db(view)
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

    override fun onBindViewHolder(holder: db, position: Int) {
        val a=itemList[position]
        holder.item.text="Item : ${a.item}"
        holder.price.text="Dicounted price : ${a.price}"
        holder.use.text="Use : ${a.use}"

    }


}