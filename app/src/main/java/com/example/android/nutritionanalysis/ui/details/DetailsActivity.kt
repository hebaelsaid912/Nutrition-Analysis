package com.example.android.nutritionanalysis.ui.details

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.nutritionanalysis.R
import com.example.android.nutritionanalysis.databinding.ActivityDetailsBinding
import com.example.android.nutritionanalysis.pojo.ingredient_details.IngredientDetailsModel
import com.example.android.nutritionanalysis.pojo.nutrition_data.NutritionData
import com.example.android.nutritionanalysis.ui.full_calculator.FullNutritionCalculateActivity
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    private val viewModel: DetailsViewModel by viewModel()
    private val ingredientDetailsList = ArrayList<IngredientDetailsModel>()
    private val nutritionDataList = ArrayList<NutritionData>()
    private lateinit var ingredientDataAdapter: IngredientDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        val ingredientItems = intent.getStringArrayListExtra("ingredient_items")
        if (ingredientItems != null) {
            for (i in ingredientItems) {
                Log.d(
                    "DetailsActivity",
                    " ingredientItems is $i"
                )
            }
        }
        lifecycleScope.launchWhenCreated {
            if (ingredientItems != null) {
                processRenderCustomersList(ingredientItems)
                delay(3000L)

            } else {
                Toast.makeText(
                    this@DetailsActivity,
                    "There is no ingredient passed",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.calculateBtn.setOnClickListener {
            if (nutritionDataList.isNotEmpty()) {
                val intent = Intent(this, FullNutritionCalculateActivity::class.java)
                intent.putExtra("full_nutrition", nutritionDataList)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun processRenderCustomersList(ingredient: ArrayList<String>) {
        lifecycleScope.launchWhenStarted {
            viewModel.stateCustomersData.collect {
                when (it) {
                    is DetailsViewModel.GetNutritionDataViewState.Idle -> {
                        Log.d("DetailsActivity", "GetNutritionDataViewState in idle")
                        viewModel.getNutrition(ingredient)
                    }
                    is DetailsViewModel.GetNutritionDataViewState.Success -> {
                        nutritionDataList.add(it.NutritionData)
                        val weight = String.format("%.2f", it.NutritionData.totalWeight).toDouble()
                        val calories =
                            String.format("%.2f", it.NutritionData.calories.toDouble()).toDouble()
                        ingredientDetailsList.add(
                            IngredientDetailsModel(
                                qty = it.ingredient.split(" ")[0].toInt(),
                                unit = it.ingredient.split(" ")[1],
                                food = it.ingredient.split(" ")[2],
                                calories = "$calories Kcal",
                                weight = "$weight g"
                            )
                        )
                        Log.d(
                            "DetailsActivity",
                            "Success NutritionData is ${it.NutritionData.calories}"
                        )
                        setNutritionDataListView()
                    }
                    is DetailsViewModel.GetNutritionDataViewState.Loading -> {
                        binding.loadingIngredientData.visibility = View.VISIBLE
                        Log.d("DetailsActivity", "GetNutritionDataViewState in loading")
                    }
                    is DetailsViewModel.GetNutritionDataViewState.Error -> {
                        Log.d("DetailsActivity", "Error GetNutritionDataViewState ${it.message}")
                    }
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setNutritionDataListView() {
        ingredientDataAdapter = IngredientDetailsAdapter(ingredientDetailsList)
        binding.detailsRv.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        binding.detailsRv.adapter = ingredientDataAdapter
        ingredientDataAdapter.notifyDataSetChanged()
        binding.tableLayout.visibility = View.VISIBLE
        binding.loadingIngredientData.visibility = View.GONE
    }


}