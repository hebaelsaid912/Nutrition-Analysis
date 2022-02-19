package com.example.android.nutritionanalysis.pojo.nutrition_data.total_daily

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class TotalDaily(
    val CA: CA,
    val CHOCDF: CHOCDF,
    @SerializedName("CHOCDF.net")
    val CHOCDF_net: CHOCDFNet,
    @SerializedName("SUGAR.added")
    val SUGAR_added: SUGARAdded,
    @SerializedName("Sugar.alcohol")
    val Sugar_alcohol : SugarAlcohol,
    val VITA_RAE : VITA_RAE,
    val SUGAR: SUGAR,
    val FATRN: FATRN,
    val FIBTG: FIBTG,
    val CHOLE: CHOLE,
    val ENERC_KCAL: ENERCKCAL,
    val FAMS: FAMS,
    val FAPU: FAPU,
    val FASAT: FASAT,
    val FAT: FAT,
    val FE: FE,
    val FOLDFE: FOLDFE,
    val FOLFD: FOLFD,
    val FOLAC: FOLAC,
    val K: K,
    val MG: MG,
    val NA: NA,
    val NIA: NIA,
    val P: P,
    val PROCNT: PROCNT,
    val RIBF: RIBF,
    val THIA: THIA,
    val VITB12: VITB12,
    val VITB6A: VITB6A,
    val VITC: VITC,
    val VITD: VITD,
    val VITK1: VITK1,
    val TOCPHA: TOCPHA,
    val WATER: WATER,
    val ZN: ZN
): Serializable