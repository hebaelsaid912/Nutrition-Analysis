package com.example.android.nutritionanalysis.ui.full_calculator

import com.example.android.nutritionanalysis.pojo.full_nutrition_cal.FullNutritionCalculateValueModel
import com.example.android.nutritionanalysis.pojo.nutrition_data.NutritionData

class FullNutritionCalculatorValueRepo {

    private var calories_value_x = 0.0
    private var total_fat_value_x = 0.0
    private var saturated_fat_value_x = 0.0
    private var trans_fat_value_x = 0.0
    private var cholesterol_value_x = 0.0
    private var sodium_value_x = 0.0
    private var total_carbohydrate_value_x = 0.0
    private var dietary_fiber_value_x = 0.0
    private var total_sugars_value_x = 0.0
    private var includes_value_x = 0.0
    private var protein_value_x = 0.0
    private var vitamin_value_x = 0.0
    private var calcium_value_x = 0.0
    private var iron_value_x = 0.0
    private var potassium_value_x = 0.0
    fun calculator(nutritionDataList: ArrayList<NutritionData>): FullNutritionCalculateValueModel {
        for (item in nutritionDataList) {
            if (item.calories != null) {
                calCaloriesValue(item.calories.toDouble())
            } else {
                calCaloriesValue(0.0)
            }
            if (item.totalNutrients.FAT != null) {
                calTotalFatValue(item.totalNutrients.FAT.quantity)
            } else {
                calTotalFatValue(0.0)
            }

            if (item.totalNutrients.FASAT != null) {
                calSaturatedFatValue(item.totalNutrients.FASAT.quantity)
            } else {
                calSaturatedFatValue(0.0)
            }
            if (item.totalNutrients.FATRN != null) {
                calTransFatValue(item.totalNutrients.FATRN.quantity)
            } else {
                calTransFatValue(0.0)
            }
            if (item.totalNutrients.CHOLE != null) {
                calCholesterolValue(item.totalNutrients.CHOLE.quantity)
            } else {
                calCholesterolValue(0.0)
            }
            if (item.totalNutrients.NA != null) {
                calSodiumValue(item.totalNutrients.NA.quantity)
            } else {
                calSodiumValue(0.0)
            }
            if (item.totalNutrients.CHOCDF != null) {
                calTotalCarbohydrateValue(item.totalNutrients.CHOCDF.quantity)
            } else {
                calTotalCarbohydrateValue(0.0)
            }
            if (item.totalNutrients.FIBTG != null) {
                calDietaryFiberValue(item.totalNutrients.FIBTG.quantity)
            } else {
                calDietaryFiberValue(0.0)
            }
            if (item.totalNutrients.SUGAR != null) {
                calTotalSugarsValue(item.totalNutrients.SUGAR.quantity)
            } else {
                calTotalSugarsValue(0.0)
            }
            if (item.totalNutrients.SUGAR_added != null) {
                calIncludesValue(item.totalNutrients.SUGAR_added.quantity)
            } else {
                calIncludesValue(0.0)
            }
            if (item.totalNutrients.PROCNT != null) {
                calProteinValue(item.totalNutrients.PROCNT.quantity)
            } else {
                calProteinValue(0.0)
            }
            if (item.totalNutrients.VITD != null) {
                calVitaminDValue(item.totalNutrients.VITD.quantity)
            } else {
                calVitaminDValue(0.0)
            }
            if (item.totalNutrients.CA != null) {
                calCalciumValue(item.totalNutrients.CA.quantity)
            } else {
                calCalciumValue(0.0)
            }
            if (item.totalNutrients.FE != null) {
                calIronValue(item.totalNutrients.FE.quantity)
            } else {
                calIronValue(0.0)
            }
            if (item.totalNutrients.K != null) {
                calPotassiumValue(item.totalNutrients.K.quantity)
            } else {
                calPotassiumValue(0.0)
            }
        }
        return FullNutritionCalculateValueModel(
            calories_value = calories_value_x,
            total_fat_value = total_fat_value_x,
            saturated_fat_value = saturated_fat_value_x,
            trans_fat_value = trans_fat_value_x,
            cholesterol_value = cholesterol_value_x,
            sodium_value = sodium_value_x,
            total_carbohydrate_value = total_carbohydrate_value_x,
            dietary_fiber_value = dietary_fiber_value_x,
            total_sugars_value = total_sugars_value_x,
            includes_value = includes_value_x,
            protein_value = protein_value_x,
            vitamin_value = vitamin_value_x,
            calcium_value = calcium_value_x,
            iron_value = iron_value_x,
            potassium_value = potassium_value_x,
        )
    }

    private fun calPotassiumValue(value: Double) {
        potassium_value_x += value
    }

    private fun calIronValue(value: Double) {
        iron_value_x += value
    }

    private fun calCalciumValue(value: Double) {
        calcium_value_x += value
    }

    private fun calVitaminDValue(value: Double) {
        vitamin_value_x += value
    }

    private fun calProteinValue(value: Double) {
        protein_value_x += value
    }

    private fun calIncludesValue(value: Double) {
        includes_value_x += value

    }

    private fun calTotalSugarsValue(value: Double) {
        total_sugars_value_x += value

    }

    private fun calDietaryFiberValue(value: Double) {
        dietary_fiber_value_x += value

    }

    private fun calTotalCarbohydrateValue(value: Double) {
        total_carbohydrate_value_x += value
    }

    private fun calSodiumValue(value: Double) {
        sodium_value_x += value
    }

    private fun calCholesterolValue(value: Double) {
        cholesterol_value_x += value

    }

    private fun calTransFatValue(value: Double) {
        trans_fat_value_x += value
    }

    private fun calSaturatedFatValue(value: Double) {
        saturated_fat_value_x += value
    }

    private fun calTotalFatValue(value: Double) {
        total_fat_value_x += value
    }

    private fun calCaloriesValue(value: Double) {
        calories_value_x += value
    }

}