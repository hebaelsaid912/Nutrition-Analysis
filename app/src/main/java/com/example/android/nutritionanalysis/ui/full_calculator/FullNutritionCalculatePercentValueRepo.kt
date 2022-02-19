package com.example.android.nutritionanalysis.ui.full_calculator

import com.example.android.nutritionanalysis.pojo.full_nutrition_cal.FullNutritionCalculatePercentValueModel
import com.example.android.nutritionanalysis.pojo.nutrition_data.NutritionData

class FullNutritionCalculatePercentValueRepo {

    private var total_fat_p_value_x = 0.0
    private var saturated_fat_p_value_x = 0.0
    private var trans_fat_p_value_x = 0.0
    private var cholesterol_p_value_x = 0.0
    private var sodium_p_value_x = 0.0
    private var total_carbohydrate_p_value_x = 0.0
    private var dietary_fiber_p_value_x = 0.0
    private var total_sugars_p_value_x = 0.0
    private var includes_p_value_x = 0.0
    private var protein_p_value_x = 0.0
    private var vitamin_p_value_x = 0.0
    private var calcium_p_value_x = 0.0
    private var iron_p_value_x = 0.0
    private var potassium_p_value_x = 0.0
    fun calculator(nutritionDataList: ArrayList<NutritionData>): FullNutritionCalculatePercentValueModel {
        for (item in nutritionDataList) {
            if (item.totalDaily.FAT != null) {
                calTotalFatPValue(item.totalDaily.FAT.quantity)
            } else {
                calTotalFatPValue(0.0)
            }

            if (item.totalDaily.FASAT != null) {
                calSaturatedFatPValue(item.totalDaily.FASAT.quantity)
            } else {
                calSaturatedFatPValue(0.0)
            }
            if (item.totalDaily.FATRN != null) {
                calTransFatPValue(item.totalDaily.FATRN.quantity)
            } else {
                calTransFatPValue(0.0)
            }
            if (item.totalDaily.CHOLE != null) {
                calCholesterolPValue(item.totalDaily.CHOLE.quantity)
            } else {
                calCholesterolPValue(0.0)
            }
            if (item.totalDaily.NA != null) {
                calSodiumPValue(item.totalDaily.NA.quantity)
            } else {
                calSodiumPValue(0.0)
            }
            if (item.totalDaily.CHOCDF != null) {
                calTotalCarbohydratePValue(item.totalDaily.CHOCDF.quantity)
            } else {
                calTotalCarbohydratePValue(0.0)
            }
            if (item.totalDaily.FIBTG != null) {
                calDietaryFiberPValue(item.totalDaily.FIBTG.quantity)
            } else {
                calDietaryFiberPValue(0.0)
            }
            if (item.totalDaily.SUGAR != null) {
                calTotalSugarsPValue(item.totalDaily.SUGAR.quantity)
            } else {
                calTotalSugarsPValue(0.0)
            }
            if (item.totalDaily.SUGAR_added != null) {
                calIncludesPValue(item.totalDaily.SUGAR_added.quantity)
            } else {
                calIncludesPValue(0.0)
            }
            if (item.totalDaily.PROCNT != null) {
                calProteinPValue(item.totalDaily.PROCNT.quantity)
            } else {
                calProteinPValue(0.0)
            }
            if (item.totalDaily.VITD != null) {
                calVitaminDPValue(item.totalDaily.VITD.quantity)
            } else {
                calVitaminDPValue(0.0)
            }
            if (item.totalDaily.CA != null) {
                calCalciumPValue(item.totalDaily.CA.quantity)
            } else {
                calCalciumPValue(0.0)
            }
            if (item.totalDaily.FE != null) {
                calIronPValue(item.totalDaily.FE.quantity)
            } else {
                calIronPValue(0.0)
            }
            if (item.totalDaily.K != null) {
                calPotassiumPValue(item.totalDaily.K.quantity)
            } else {
                calPotassiumPValue(0.0)
            }
        }
        return FullNutritionCalculatePercentValueModel(
            total_fat_p_value = total_fat_p_value_x,
            saturated_fat_p_value = saturated_fat_p_value_x,
            trans_fat_p_value = trans_fat_p_value_x,
            cholesterol_p_value = cholesterol_p_value_x,
            sodium_p_value = sodium_p_value_x,
            total_carbohydrate_p_value = total_carbohydrate_p_value_x,
            dietary_fiber_p_value = dietary_fiber_p_value_x,
            total_sugars_p_value = total_sugars_p_value_x,
            protein_p_value = protein_p_value_x,
            vitamin_p_value = vitamin_p_value_x,
            calcium_p_value = calcium_p_value_x,
            iron_p_value = iron_p_value_x,
            potassium_p_value = potassium_p_value_x,
        )
    }

    private fun calPotassiumPValue(p_value: Double) {
        potassium_p_value_x += p_value
    }

    private fun calIronPValue(p_value: Double) {
        iron_p_value_x += p_value
    }

    private fun calCalciumPValue(p_value: Double) {
        calcium_p_value_x += p_value
    }

    private fun calVitaminDPValue(p_value: Double) {
        vitamin_p_value_x += p_value
    }

    private fun calProteinPValue(p_value: Double) {
        protein_p_value_x += p_value
    }

    private fun calIncludesPValue(p_value: Double) {
        includes_p_value_x += p_value
    }

    private fun calTotalSugarsPValue(p_value: Double) {
        total_sugars_p_value_x += p_value
    }

    private fun calDietaryFiberPValue(p_value: Double) {
        dietary_fiber_p_value_x += p_value
    }

    private fun calTotalCarbohydratePValue(p_value: Double) {
        total_carbohydrate_p_value_x += p_value
    }

    private fun calSodiumPValue(p_value: Double) {
        sodium_p_value_x += p_value
    }

    private fun calCholesterolPValue(p_value: Double) {
        cholesterol_p_value_x += p_value
    }

    private fun calTransFatPValue(p_value: Double) {
        trans_fat_p_value_x += p_value
    }

    private fun calSaturatedFatPValue(p_value: Double) {
        saturated_fat_p_value_x += p_value
    }

    private fun calTotalFatPValue(p_value: Double) {
        total_fat_p_value_x += p_value
    }

}