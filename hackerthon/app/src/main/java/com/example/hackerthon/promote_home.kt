package com.example.hackerthon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var bt14:Button
lateinit var bt15:Button
class promote_home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promote_home)

        bt14=findViewById(R.id.psb1)
        bt15=findViewById(R.id.psb2)
        bt14.setOnClickListener {
            val i= Intent(this@promote_home,sell_product::class.java)
            startActivity(i)
        }
        bt15.setOnClickListener {
            val i= Intent(this@promote_home,buy_product::class.java)
            startActivity(i)
        }
    }
}