package com.example.hackerthon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*

lateinit var e1:EditText
lateinit var sp2:SharedPreferences
lateinit var b1:Button
private lateinit var database: DatabaseReference
class Problem_S : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_s)
        sp2=getSharedPreferences("email", Context.MODE_PRIVATE)
        var email4=sp2.getString("email","").toString()
        e1=findViewById(R.id.chpe1)
        b1=findViewById(R.id.chpb1)

        b1.setOnClickListener {
            database = FirebaseDatabase.getInstance().getReference("issue")
            var e2=e1.text.toString()
            var sn="0"
            database.addValueEventListener(object: ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get Post object and use the values to update the UI
                    for (s in dataSnapshot.children) {
                        sn=s.child("sno").getValue().toString()



                        }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })


sn=(sn.toInt()+1).toString()
            database.child(email4).child("sno").setValue(sn)
            database.child(email4).child("issue"+" $sn").setValue(e2)
        }
    }
}