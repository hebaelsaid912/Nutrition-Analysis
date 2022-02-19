package com.example.android.nutritionanalysis.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.nutritionanalysis.R
import com.example.android.nutritionanalysis.pojo.ingredient_details.IngredientDetailsModel

class IngredientDetailsAdapter(private val ingredientList:ArrayList<IngredientDetailsModel>)
    :RecyclerView.Adapter<IngredientDetailsAdapter.IngredientDetailsHolder>(){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientDetailsHolder {
        context = parent.context
        return IngredientDetailsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.ingredient_details_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: IngredientDetailsHolder, position: Int) {
        if(ingredientList.isNullOrEmpty())
            return
       holder.bind(ingredientList[position])
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }
    inner class IngredientDetailsHolder(view: View):RecyclerView.ViewHolder(view){
        private val qty = view.findViewById<TextView>(R.id.qty_data_tv)
        private val unit = view.findViewById<TextView>(R.id.unit_data_tv)
        private val food = view.findViewById<TextView>(R.id.food_data_tv)
        private val calories = view.findViewById<TextView>(R.id.calories_data_tv)
        private val weight = view.findViewById<TextView>(R.id.weight_data_tv)
        fun bind(ingredientData: IngredientDetailsModel){
            qty.text = ingredientData.qty.toString()
            unit.text = ingredientData.unit
            food.text = ingredientData.food
            calories.text = ingredientData.calories
            weight.text = ingredientData.weight
        }
    }

}