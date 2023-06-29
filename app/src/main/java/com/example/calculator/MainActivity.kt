package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(view: View) {
        if (view is Button) {
            val number: String = view.text.toString()
            val currentResult: String = resultTextView.text.toString()

            resultTextView.text = currentResult + number
        }
    }

    fun operatorClick(view: View) {
        if (view is Button) {
            operator = view.text.toString()
            val currentResult: String = resultTextView.text.toString()

            operand1 = currentResult.toDouble()
            resultTextView.text = ""
        }
    }

    fun calculateResult(view: View) {
        val currentResult: String = resultTextView.text.toString()
        operand2 = currentResult.toDouble()

        val result: Double = when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }

        resultTextView.text = result.toString()
    }

    fun clearResult(view: View) {
        resultTextView.text = ""
        operand1 = 0.0
        operand2 = 0.0
        operator = ""
    }
}
