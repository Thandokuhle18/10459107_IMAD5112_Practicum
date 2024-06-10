package com.example.weatherapppracticum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainScreen = findViewById<Button>(R.id.mainScreen)
        mainScreen.setOnClickListener {
// create the explicit intent
            val intent = Intent(this, Mainscreen::class.java)
// start the activity
            startActivity(intent)

            val exit = findViewById<Button>(R.id.Exit)

            exit.setOnClickListener {
                finishAffinity()
                System.exit(0)


            }
        }
    }
}

