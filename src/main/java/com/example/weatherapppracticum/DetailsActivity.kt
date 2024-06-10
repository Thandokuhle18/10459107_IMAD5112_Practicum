package com.example.weatherapppracticum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    private lateinit var backButton: Button
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        backButton = findViewById(R.id.Back)
        listView = findViewById(R.id.listView)

        backButton.setOnClickListener {
            finish()
        }

        val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val temperatures = intent.getDoubleArrayExtra("temperatures")
        val maxTemperatures = intent.getDoubleArrayExtra("maxTemperatures")
        val minTemperatures = intent.getDoubleArrayExtra("minTemperatures")
        val weatherConditions = intent.getStringArrayExtra("weatherConditions")

        val listItems = ArrayList<String>()
        for (i in days.indices) {
            val temperature = temperatures?.get(i) ?: 10.0
            val maxTemperature = maxTemperatures?.get(i) ?: 18.0
            val minTemperature = minTemperatures?.get(i) ?: 7.0
            val weatherCondition = weatherConditions?.get(i) ?: "Sunny"

            listItems.add("Day: ${days[i]}\nTemperature: ${temperature}°C\nMax Temperature: ${maxTemperature}°C\nMin Temperature: ${minTemperature}°C\nWeather Condition: ${weatherCondition}")

        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

    }
    }
