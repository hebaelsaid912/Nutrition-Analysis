package com.example.android.nutritionanalysis.pojo.nutrition_data.total_daily

import java.io.Serializable

data class SugarAlcohol(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable