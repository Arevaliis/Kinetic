package com.example.kinetic.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kinetic.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butonEntrar: Button = findViewById(R.id.botonEntrar)

        butonEntrar.setOnClickListener {

         val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}