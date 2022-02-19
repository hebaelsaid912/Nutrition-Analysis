package com.example.android.nutritionanalysis.ui.full_calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.android.nutritionanalysis.R
import com.example.android.nutritionanalysis.databinding.ActivityFullNutritionCalculateBinding
import com.example.android.nutritionanalysis.pojo.full_nutrition_cal.FullNutritionCalculatePercentValueModel
import com.example.android.nutritionanalysis.pojo.full_nutrition_cal.FullNutritionCalculateValueModel
import com.example.android.nutritionanalysis.pojo.nutrition_data.NutritionData
import kotlin.math.roundToInt

class FullNutritionCalculateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullNutritionCalculateBinding
    private val viewModel: FullNutritionCalculateViewModel by lazy {
        ViewModelProvider(this)[FullNutritionCalculateViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_full_nutrition_calculate)
        val nutritionDataListFromIntent = intent.getSerializableExtra("full_nutrition") as ArrayList<NutritionData>
        for(i in nutritionDataListFromIntent){
            Log.d("FullNutritionCalculateActivity", i.calories.toString())
        }
        processRenderCustomersList(nutritionDataListFromIntent)
    }
    private fun processRenderCustomersList(nutritionDataList: ArrayList<NutritionData>) {
        lifecycleScope.launchWhenStarted {
            viewModel.stateNutritionCalculate.collect {
                when (it) {
                    is FullNutritionCalculateViewModel.GetNutritionCalculateViewState.Idle -> {
                        Log.d("FullNutritionCalculateActivity", "GetNutritionCalculateViewState in idle")
                        viewModel.getCalculationOfNutritionDataList(nutritionDataList)
                    }
                    is FullNutritionCalculateViewModel.GetNutritionCalculateViewState.Success -> {
                        Log.d("FullNutritionCalculateActivity", "GetNutritionCalculateViewState in Success")

                        setViewsValue(it.fullNutritionCalculateValueModel)
                        setViewsPercentValue(it.fullNutritionCalculatePercentValueModel)
                    }
                    is FullNutritionCalculateViewModel.GetNutritionCalculateViewState.Loading -> {
                        binding.loadingNutritionData.visibility = View.VISIBLE
                        Log.d("FullNutritionCalculateActivity", "GetNutritionCalculateViewState in Loading")

                    }
                    is FullNutritionCalculateViewModel.GetNutritionCalculateViewState.Error -> {
                        Log.d("FullNutritionCalculateActivity", "Error GetNutritionCalculateViewState ${it.message}")
                    }
                    else -> Unit
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setViewsValue(data: FullNutritionCalculateValueModel) {
        if(data.calories_value != 0.0) {
            binding.caloriesValueTv.text = String.format("%.2f", data.calories_value)
        }else{
            binding.caloriesValueTv.text = "-"
        }
        if(data.total_fat_value != 0.0) {
            binding.totalFatValue.text = String.format("%.2f",data.total_fat_value)+" g"
        }else{
            binding.totalFatValue.text = "-"
        }
        if(data.saturated_fat_value != 0.0) {
            binding.saturatedFatValue.text = String.format("%.2f",data.saturated_fat_value)+" g"
        }else{
            binding.saturatedFatValue.text = "-"
        }
        if(data.trans_fat_value != 0.0) {
            binding.transFatValue.text = String.format("%.2f",data.trans_fat_value)+" g"
        }else{
            binding.transFatValue.text = "-"
        }
        if(data.cholesterol_value != 0.0) {
            binding.cholesterolValue.text = String.format("%.2f",data.cholesterol_value)+" mg"
        }else{
            binding.cholesterolValue.text = "-"
        }
        if(data.sodium_value != 0.0) {
            binding.sodiumValue.text = String.format("%.2f",data.sodium_value)+" mg"
        }else{
            binding.sodiumValue.text = "-"
        }
        if(data.total_carbohydrate_value != 0.0) {
            binding.totalCarbohydrateValue.text = String.format("%.2f",data.total_carbohydrate_value)+" g"
        }else{
            binding.totalCarbohydrateValue.text = "-"
        }
        if(data.dietary_fiber_value != 0.0) {
            binding.dietaryFiberValue.text = String.format("%.2f",data.dietary_fiber_value)+" g"
        }else{
            binding.dietaryFiberValue.text = "-"
        }
        if(data.total_sugars_value != 0.0) {
            binding.totalSugarsValue.text = String.format("%.2f",data.total_sugars_value)+" g"
        }else{
            binding.totalSugarsValue.text = "-"
        }
        if(data.includes_value != 0.0) {
            binding.includesValue.text = "Added Sugars"
        }else{
            binding.includesValue.text = "-"
        }
        if(data.protein_value != 0.0) {
            binding.proteinValue.text = String.format("%.2f",data.protein_value)+" g"
        }else{
            binding.proteinValue.text = "-"
        }
        if(data.vitamin_value != 0.0) {
            binding.vitaminValue.text = String.format("%.2f",data.vitamin_value)+" µg"
        }else{
            binding.vitaminValue.text = "-"
        }
        if(data.calcium_value != 0.0) {
            binding.calciumValue.text = String.format("%.2f",data.calcium_value)+" mg"
        }else{
            binding.calciumValue.text = "-"
        }
        if(data.iron_value != 0.0) {
            binding.ironValue.text = String.format("%.2f",data.iron_value)+" mg"
        }else{
            binding.ironValue.text = "-"
        }
        if(data.potassium_value != 0.0) {
            binding.potassiumValue.text = String.format("%.2f",data.potassium_value)+" mg"
        }else{
            binding.potassiumValue.text = "-"
        }
        binding.loadingNutritionData.visibility = View.GONE
        binding.tableLayout.visibility = View.VISIBLE
        binding.card.visibility = View.VISIBLE

    }
    @SuppressLint("SetTextI18n")
    private fun setViewsPercentValue(data: FullNutritionCalculatePercentValueModel) {
        if(data.total_fat_p_value != 0.0) {
            val v = String.format("%.2f",data.total_fat_p_value).toDouble()
            binding.totalFatPValue.text = "${v.roundToInt()} %"
        }else{
            binding.totalFatPValue.text = "-"
        }
        if(data.saturated_fat_p_value != 0.0) {
            val v = String.format("%.2f",data.saturated_fat_p_value).toDouble()
            binding.saturatedFatPValue.text = "${v.roundToInt()} %"
        }else{
            binding.saturatedFatPValue.text = "-"
        }
        if(data.trans_fat_p_value != 0.0) {
            val v = String.format("%.2f",data.trans_fat_p_value).toDouble()
            binding.transFatPValue.text = "${v.roundToInt()} %"
        }else{
            binding.transFatPValue.text = "-"
        }
        if(data.cholesterol_p_value != 0.0) {
            val v = String.format("%.2f",data.cholesterol_p_value).toDouble()
            binding.cholesterolPValue.text = "${v.roundToInt()} %"
        }else{
            binding.cholesterolPValue.text = "-"
        }
        if(data.sodium_p_value != 0.0) {
            val v = String.format("%.2f",data.sodium_p_value).toDouble()
            binding.sodiumPValue.text = "${v.roundToInt()} %"
        }else{
            binding.sodiumPValue.text = "-"
        }
        if(data.total_carbohydrate_p_value != 0.0) {
            val v = String.format("%.2f",data.total_carbohydrate_p_value).toDouble()
            binding.totalCarbohydratePValue.text = "${v.roundToInt()} %"
        }else{
            binding.totalCarbohydratePValue.text = "-"
        }
        if(data.dietary_fiber_p_value != 0.0) {
            val v = String.format("%.2f",data.dietary_fiber_p_value).toDouble()
            binding.dietaryFiberPValue.text = "${v.roundToInt()} %"
        }else{
            binding.dietaryFiberPValue.text = "-"
        }
        if(data.total_sugars_p_value != 0.0) {
            val v = String.format("%.2f",data.total_sugars_p_value).toDouble()
            binding.totalSugarsPValue.text = "${v.roundToInt()} %"
        }else{
            binding.totalSugarsPValue.text = "-"
        }
        if(data.protein_p_value != 0.0) {
            val v = String.format("%.2f",data.protein_p_value).toDouble()
            binding.proteinPValue.text = "${v.roundToInt()} %"
        }else{
            binding.proteinPValue.text = "-"
        }
        if(data.vitamin_p_value != 0.0) {
            val v = String.format("%.2f",data.vitamin_p_value).toDouble()
            binding.vitaminPValue.text = "${v.roundToInt()} %"
        }else{
            binding.vitaminPValue.text = "-"
        }
        if(data.calcium_p_value != 0.0) {
            val v = String.format("%.2f",data.calcium_p_value).toDouble()
            binding.calciumPValue.text = "${v.roundToInt()} %"
        }else{
            binding.calciumPValue.text = "-"
        }
        if(data.iron_p_value != 0.0) {
            val v = String.format("%.2f",data.iron_p_value).toDouble()
            binding.ironPValue.text = "${v.roundToInt()} %"
        }else{
            binding.ironPValue.text = "-"
        }
        if(data.potassium_p_value != 0.0) {
            val v = String.format("%.2f",data.potassium_p_value).toDouble()
            binding.potassiumPValue.text = "${v.roundToInt()} %"
        }else{
            binding.potassiumPValue.text = "-"
        }
    }

}