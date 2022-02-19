package com.example.android.nutritionanalysis.remote_data.repo

import com.example.android.nutritionanalysis.pojo.nutrition_data.NutritionData
import retrofit2.http.Query

interface NutritionRepoInterface {
    suspend fun getNutritionAnalysisData(@Query("app_id") id: String,
                                         @Query("app_key") key: String,
                                         @Query("nutrition-type") type: String,
                                         @Query("ingr") ingr: String) : NutritionData
}