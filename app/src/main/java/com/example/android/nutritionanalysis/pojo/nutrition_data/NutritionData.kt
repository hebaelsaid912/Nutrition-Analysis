package com.example.android.nutritionanalysis.pojo.nutrition_data

import com.example.android.nutritionanalysis.pojo.nutrition_data.total_daily.TotalDaily
import com.example.android.nutritionanalysis.pojo.nutrition_data.total_nutrients.TotalNutrients
import com.example.android.nutritionanalysis.pojo.nutrition_data.total_nutrients_k_cal.TotalNutrientsKCal
import java.io.Serializable

data class NutritionData(
    val calories: Int,
    val cautions: List<Any>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalNutrientsKCal: TotalNutrientsKCal,
    val totalWeight: Double,
    val uri: String
): Serializable