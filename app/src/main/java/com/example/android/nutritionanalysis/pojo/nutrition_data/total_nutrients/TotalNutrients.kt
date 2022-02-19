package com.example.android.nutritionanalysis.pojo.nutrition_data.total_nutrients

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TotalNutrients(
    val CA: CAX,
    val CHOCDF: CHOCDFX,
    @SerializedName("CHOCDF.net")
    val CHOCDF_net: CHOCDFNetX,
    @SerializedName("SUGAR.added")
    val SUGAR_added: SUGARAddedX,
    @SerializedName("Sugar.alcohol")
    val Sugar_alcohol: SugarAlcoholX,
    val VITA_RAE: VITA_RAEX,
    val CHOLE: CHOLEX,
    val SUGAR: SUGARX,
    val ENERC_KCAL: ENERCKCALX,
    val FAMSX: FAMSX,
    val FAPUX: FAPUX,
    val FASAT: FASATX,
    val FATRN: FATRNX,
    val FIBTG: FIBTGX,
    val FAT: FATX,
    val FE: FEX,
    val FOLACX: FOLACX,
    val FOLDFE: FOLDFEX,
    val FOLFDX: FOLFDX,
    val K: KX,
    val MG: MGX,
    val NA: NAX,
    val NIA: NIAX,
    val P: PX,
    val PROCNT: PROCNTX,
    val RIBF: RIBFX,
    val THIA: THIAX,
    val VITB12: VITB12X,
    val VITB6A: VITB6AX,
    val VITC: VITCX,
    val VITD: VITDX,
    val VITK1: VITK1X,
    val TOCPHA: TOCPHAX,
    val WATERX: WATERX,
    val ZN: ZNX
) : Serializable