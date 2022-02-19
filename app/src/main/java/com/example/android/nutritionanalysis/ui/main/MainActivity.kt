package com.example.android.nutritionanalysis.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android.nutritionanalysis.R
import com.example.android.nutritionanalysis.databinding.ActivityMainBinding
import com.example.android.nutritionanalysis.ui.details.DetailsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val ingredientDataList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.analysisBtn.setOnClickListener {
            val enteredIngredient = binding.ingredientLayout.editText?.text
            if (!enteredIngredient.isNullOrEmpty()) {
                binding.ingredientLayout.error = null
                val ingredientItems = enteredIngredient.split("\n")
                for (i in ingredientItems) {
                    if (i.split(" ").size != 3) {
                        binding.ingredientLayout.boxStrokeErrorColor
                        binding.ingredientLayout.error =
                            "each line should be in structure [ amount unit item ]"
                        Toast.makeText(
                            this@MainActivity,
                            "each line should be in structure [ amount unit item ]",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        ingredientDataList.add(i)
                    }
                    Log.d("MainActivity", "ingredientItem is $i")
                }
                if (ingredientDataList.isNotEmpty()) {
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtra("ingredient_items", ingredientDataList)
                    startActivity(intent)
                }
            } else {
                binding.ingredientLayout.boxStrokeErrorColor
                binding.ingredientLayout.error = "Ingredient field can not be empty!"
            }
        }
        binding.newRecipeBtn.setOnClickListener {
            binding.ingredientLayout.editText?.setText("")
            binding.ingredientLayout.editText?.isFocusableInTouchMode = true
            binding.ingredientLayout.error = null
        }

    }

    override fun onResume() {
        super.onResume()
        ingredientDataList.clear()
    }


}