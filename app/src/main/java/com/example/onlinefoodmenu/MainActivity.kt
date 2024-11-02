package com.example.onlinefoodmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.onlinefoodmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
        binding.buttonOrder.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_Calculate) {
            if (isValid()) {
                calculate()
            } else {
                Toast.makeText(this, R.string.validation_Fill_All_Fields_1, Toast.LENGTH_SHORT)
                    .show()
                Toast.makeText(this, R.string.validation_Fill_All_Fields_2, Toast.LENGTH_SHORT)
                    .show()
                binding.textLabelResul.text = "R$ 0,00"
            }
        }
        if (view.id == R.id.button_Order) {
            if (isValid()) {
                calculate()
                Toast.makeText(this, R.string.validation_Order, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.validation_Fill_All_Fields_2, Toast.LENGTH_SHORT)
                    .show()
                binding.textLabelResul.text = "R$ 0,00"
            }
        }
    }

    private fun isValid(): Boolean {
        return (binding.checkDish1.isChecked ||
                binding.checkDish2.isChecked ||
                binding.checkDish3.isChecked ||
                binding.checkDish4.isChecked ||
                binding.checkDrink1.isChecked ||
                binding.checkDrink2.isChecked)
    }

    private fun calculate() {
        var vlrTotal = 0.0f
        if (binding.checkDish1.isChecked) {
            vlrTotal += 30.0f
        }
        if (binding.checkDish2.isChecked) {
            vlrTotal += 35.0f
        }
        if (binding.checkDish3.isChecked) {
            vlrTotal += 55.0f
        }
        if (binding.checkDish4.isChecked) {
            vlrTotal += 45.0f
        }
        if (binding.checkDrink1.isChecked) {
            vlrTotal += 15.90f
        }
        if (binding.checkDrink2.isChecked) {
            vlrTotal += 18.60f
        }
        binding.textLabelResul.text = "R$ ${"%.2f".format(vlrTotal)}"
    }
}