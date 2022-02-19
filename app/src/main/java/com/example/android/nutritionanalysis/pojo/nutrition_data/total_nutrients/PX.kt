package com.example.android.nutritionanalysis.pojo.nutrition_data.total_nutrients

import java.io.Serializable

data class PX(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable