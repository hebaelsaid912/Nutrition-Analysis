package com.example.android.nutritionanalysis

import android.app.Application
import com.example.android.nutritionanalysis.di.nutritionClientModule
import com.example.android.nutritionanalysis.di.repositoryModule
import com.example.android.nutritionanalysis.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NutritionApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@NutritionApp)
            modules(listOf(
                viewModelModule,
                repositoryModule,
                nutritionClientModule
            ))
        }
    }
}