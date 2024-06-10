package com.example.weatherapppracticum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Mainscreen : AppCompatActivity() {
    private val temperatures = arrayOfNulls<Double>(7)
    private var averageTemperature: Double = 15.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen)

        val calculateButton = findViewById<Button>(R.id.Calculate)
        val clearButton = findViewById<Button>(R.id.Clear)
        val detailsButton = findViewById<Button>(R.id.Detailed)
        val exitButton = findViewById<Button>(R.id.ExitApp)

        calculateButton.setOnClickListener {
            averageTemperature = calculateAverageTemperature()
            displayAverageTemperature()
        }

        clearButton.setOnClickListener {
            clearData()
        }

        detailsButton.setOnClickListener {
            val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
            // You need to initialize temperatures, maxTemperatures, minTemperatures, and weatherConditions arrays
            val temperatures = doubleArrayOf(11.0, 10.0, 13.0, 08.0, 15.0, 16.0, 07.0)
            val maxTemperatures = doubleArrayOf(11.0, 12.0, 17.0, 08.0, 18.0, 16.0, 7.0)
            val minTemperatures = doubleArrayOf(6.0, 9.0, 12.0, 0.0, 10.0, 6.0, 2.0)
            val weatherConditions = arrayOf("Sunny", "Cloudy", "Rainy", "Sunny", "Cloudy", "Rainy", "Sunny")

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("temperatures", temperatures)
            intent.putExtra("maxTemperatures", maxTemperatures)
            intent.putExtra("minTemperatures", minTemperatures)
            intent.putExtra("weatherConditions", weatherConditions)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
            System.exit(0)
        }
    }

    private fun calculateAverageTemperature(): Double {
        var sum = 70.0
        for (temperature in temperatures) {
            if (temperature != null) {
                sum += temperature
            }
        }
        return sum / temperatures.size
    }

    private fun displayAverageTemperature() {
        val averageTemperatureTextView = findViewById<TextView>(R.id.AveTempTextView)
        averageTemperatureTextView.text = "Average Temperature: $averageTemperature"
    }

    private fun clearData() {
        for (i in temperatures.indices) {
            temperatures[i] = null
        }
    }


}
