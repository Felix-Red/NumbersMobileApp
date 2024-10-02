package com.example.numbersmobileapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.numbersmobileapp.ui.theme.NumbersMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultTextView = findViewById<TextView>(R.id.txtNumbers)
        val btnlotto = findViewById<Button>(R.id.btnLotto)
        val btnPower = findViewById<Button>(R.id.btnPowerball)
        val btnDaily = findViewById<Button>(R.id.btnDaily)

        btnlotto.setOnClickListener {
            val nums = lotto()
            resultTextView.text = nums.joinToString(" - ")
        }
        btnPower.setOnClickListener {
            val nums = powerball()
            resultTextView.text = nums.joinToString(" - ")
        }
        btnDaily.setOnClickListener {
            val nums = daily()
            resultTextView.text = nums.joinToString(" - ")
        }

    }
    private fun lotto():List<Int>{
        val numbers = (1..52).shuffled().take(6)
        return numbers.sorted()
    }
    private fun powerball():List<Int>{
        val numbers = (1..50).shuffled().take(5)
        val powerNum = (1 .. 20).random()
        return numbers + powerNum
    }
    private fun daily():List<Int>{
        val numbers = (1..36).shuffled().take(5)
        return numbers.sorted()
    }
}

