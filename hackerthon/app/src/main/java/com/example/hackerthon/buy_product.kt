package com.example.hackerthon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

lateinit var l:RecyclerView.LayoutManager
lateinit var rec:RecyclerView
private lateinit var database: DatabaseReference
var array= arrayListOf<govt_sign>()
class buy_product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_product)
        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
  val email2=sp.getString("email","")
        rec=findViewById(R.id.rec)

        database = FirebaseDatabase.getInstance().getReference("sell")

        database.addValueEventListener(object: ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                for (s in dataSnapshot.children) {

               array.add( govt_sign(s.child("item").getValue().toString(),s.child("use").getValue().toString(),s.child("price").getValue().toString()))

                }
                }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message

            }

        })

        l=LinearLayoutManager(this@buy_product)

        rec.adapter=adapter(this@buy_product,array)
        rec.layoutManager=l
        array.clear()
    }

    override fun onBackPressed() {
        var i = Intent(this@buy_product, home_citizen::class.java)
        startActivity(i)
        super.onBackPressed()

    }
}