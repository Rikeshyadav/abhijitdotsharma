package com.example.hackerthon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var edit12:EditText
lateinit var edit22:EditText
lateinit var edit32:EditText
lateinit var but27:Button
private lateinit var database: DatabaseReference
class sell_product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_product)
        edit12=findViewById(R.id.pselle1)
        edit22=findViewById(R.id.pselle2)
        edit32=findViewById(R.id.pselle3)

        but27=findViewById(R.id.pselle4)

        but27.setOnClickListener {

            val item=edit12.text.toString()
            val use=edit22.text.toString()
            val price=edit32.text.toString()

            sp=getSharedPreferences("email", Context.MODE_PRIVATE)
          val email=sp.getString("email","").toString()
            database = FirebaseDatabase.getInstance().getReference("sell")
            database.child(email).child("Item").setValue(item)
            database.child(email).child("use").setValue(use)
            database.child(email).child("price").setValue(price)
            Toast.makeText(this@sell_product, "shared", Toast.LENGTH_SHORT).show();


        }


    }
}