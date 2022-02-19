package com.example.android.nutritionanalysis.pojo.nutrition_data.total_nutrients

import java.io.Serializable

data class NAX(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable