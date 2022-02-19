package com.example.android.nutritionanalysis.ui.full_calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.nutritionanalysis.pojo.full_nutrition_cal.FullNutritionCalculatePercentValueModel
import com.example.android.nutritionanalysis.pojo.full_nutrition_cal.FullNutritionCalculateValueModel
import com.example.android.nutritionanalysis.pojo.nutrition_data.NutritionData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class FullNutritionCalculateViewModel : ViewModel() {
    private val _viewStateNutritionCalculate = MutableStateFlow<GetNutritionCalculateViewState>(
        GetNutritionCalculateViewState.Idle
    )
    val stateNutritionCalculate: StateFlow<GetNutritionCalculateViewState> get() = _viewStateNutritionCalculate
    private val fullNutritionCalculatorValueRepo = FullNutritionCalculatorValueRepo()
    private val fullNutritionCalculatePercentValueRepo = FullNutritionCalculatePercentValueRepo()
    sealed class GetNutritionCalculateViewState {
        data class Success(
            val fullNutritionCalculateValueModel: FullNutritionCalculateValueModel,
            val fullNutritionCalculatePercentValueModel: FullNutritionCalculatePercentValueModel
        ) : GetNutritionCalculateViewState()

        data class Error(val message: String) : GetNutritionCalculateViewState()
        object Loading : GetNutritionCalculateViewState()
        object Idle : GetNutritionCalculateViewState()
    }

    fun getCalculationOfNutritionDataList(
        nutritionDataList: ArrayList<NutritionData>
    ) = viewModelScope.launch {
        GetNutritionCalculateViewState.Loading
        delay(2000L)
        _viewStateNutritionCalculate.value = try {
            GetNutritionCalculateViewState.Success(
                calNutritionValue(nutritionDataList),
                calNutritionPercentValue(nutritionDataList)
            )
        } catch (ex: Exception) {
            GetNutritionCalculateViewState.Error(ex.message!!)
        }
    }


    private fun calNutritionValue(nutritionDataList: ArrayList<NutritionData>)
            : FullNutritionCalculateValueModel {
        return fullNutritionCalculatorValueRepo.calculator(nutritionDataList = nutritionDataList)

    }

    private fun calNutritionPercentValue(nutritionDataList: ArrayList<NutritionData>)
            : FullNutritionCalculatePercentValueModel {
        return fullNutritionCalculatePercentValueRepo.calculator(nutritionDataList = nutritionDataList)
    }


}