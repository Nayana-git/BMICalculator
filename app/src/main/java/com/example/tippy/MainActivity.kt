package com.example.tippy


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var etWeightValue: EditText
    private lateinit var etHeightValue: EditText
    private lateinit var tvBMIValue: TextView
    private lateinit var tvBMIDescription: TextView
    private lateinit var btnCalculate : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etWeightValue = findViewById(R.id.etWeightValue)
        etHeightValue = findViewById(R.id.etHeightValue)
        tvBMIValue = findViewById(R.id.tvBMIValue)
        tvBMIDescription = findViewById(R.id.tvBMIDescription)
        btnCalculate = findViewById(R.id.btnCalculate) as Button

        btnCalculate.setOnClickListener{
            computeBMI()
        }
    }

    private fun updateBMIDescription(tipPercent: Double) {
        val bmiDescription = when(tipPercent){
            in 0.0..18.5 -> "Underweight"
            in 18.5..24.9 -> "Normal Weight"
            in 25.0..29.9 -> "Overweight"
            else -> "Obesity"
        }
        tvBMIDescription.text = bmiDescription

    }

    private fun computeBMI() {
        if(etWeightValue.text.isEmpty()){
            tvBMIValue.text = ""
            return
        }

        val weightValue = etWeightValue.text.toString().toDouble()
        val heightValue = etHeightValue.text.toString().toDouble()

        val bmiValue = weightValue /heightValue/heightValue * 703


        tvBMIValue.text = "%.1f".format(bmiValue)
        updateBMIDescription(bmiValue)

    }
}