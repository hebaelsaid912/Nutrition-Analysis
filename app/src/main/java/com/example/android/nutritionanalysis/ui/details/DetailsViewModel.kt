package com.example.android.nutritionanalysis.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.nutritionanalysis.pojo.nutrition_data.NutritionData
import com.example.android.nutritionanalysis.pojo.repo.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


private const val NUTRITION_TYPE = "cooking"
private const val APP_KEY = "e5b18892e037f6f0ad28119e336bfb43"
private const val APP_ID = "e2449c49"

class DetailsViewModel(private val repository: Repository): ViewModel() {
    private val _viewStateNutritionData = MutableStateFlow<GetNutritionDataViewState>(GetNutritionDataViewState.Idle)
    val stateCustomersData: StateFlow<GetNutritionDataViewState> get() = _viewStateNutritionData


    sealed class GetNutritionDataViewState {
        data class Success(var NutritionData: NutritionData,var ingredient:String) : GetNutritionDataViewState()
        data class Error(val message: String) : GetNutritionDataViewState()
        object Loading : GetNutritionDataViewState()
        object Idle : GetNutritionDataViewState()
    }
    fun getNutrition(ingredient:ArrayList<String>) = viewModelScope.launch {
        _viewStateNutritionData.value = GetNutritionDataViewState.Loading
        delay(2000L)
        for (i in ingredient) {
            _viewStateNutritionData.value = try {
                GetNutritionDataViewState.Success(getNutritionData(ingredient = i),i)
            } catch (ex: Exception) {
                GetNutritionDataViewState.Error(ex.message!!)
            }
        }
    }
    private fun getNutritionData(
        ingredient:String
    ) : NutritionData = runBlocking{
        return@runBlocking repository.getNutritionAnalysisData(
            id = APP_ID,
            key = APP_KEY,
            type = NUTRITION_TYPE,
            ingr = ingredient
        )
    }
}