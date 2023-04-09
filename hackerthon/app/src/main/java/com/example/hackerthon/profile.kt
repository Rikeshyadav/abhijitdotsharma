package com.example.hackerthon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

lateinit var txt1:TextView
lateinit var txt2:TextView
class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        txt1=findViewById(R.id.p1)
        txt2=findViewById(R.id.p2)
        sp=getSharedPreferences("name", Context.MODE_PRIVATE)

        txt1.text="Name : ${sp.getString("name","")}"
        sp=getSharedPreferences("email", Context.MODE_PRIVATE)
        txt2.text="Email : ${sp.getString("email","")}"
    }
}