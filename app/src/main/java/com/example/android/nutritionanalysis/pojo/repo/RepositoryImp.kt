package com.example.android.nutritionanalysis.pojo.repo

import com.example.android.nutritionanalysis.remote_data.repo.NutritionRepoInterface

class RepositoryImp(private val nutritionRepoInterface: NutritionRepoInterface):Repository {
    override suspend fun getNutritionAnalysisData(
        id: String,
        key: String,
        type: String,
        ingr: String
    ) = nutritionRepoInterface.getNutritionAnalysisData(id,key,type,ingr)
}