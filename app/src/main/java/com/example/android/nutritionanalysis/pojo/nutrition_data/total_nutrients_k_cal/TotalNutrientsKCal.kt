package com.example.android.nutritionanalysis.pojo.nutrition_data.total_nutrients_k_cal

import java.io.Serializable


data class TotalNutrientsKCal(
    val CHOCDF_KCAL: CHOCDFKCAL,
    val ENERC_KCAL: ENERCKCALXX,
    val FAT_KCAL: FATKCAL,
    val PROCNT_KCAL: PROCNTKCAL
): Serializable