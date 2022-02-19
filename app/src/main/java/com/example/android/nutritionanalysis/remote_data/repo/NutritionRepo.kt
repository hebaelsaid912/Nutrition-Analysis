package com.example.android.nutritionanalysis.remote_data.repo

import com.example.android.nutritionanalysis.remote_data.NutritionInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class NutritionRepo(private val api:NutritionInterface) : NutritionRepoInterface{

    override suspend fun getNutritionAnalysisData(
        id: String,
        key: String,
        type: String,
        ingr: String
    ) = withContext(Dispatchers.IO){
            api.getNutritionAnalysisData(id,key,type,ingr)
        }


}