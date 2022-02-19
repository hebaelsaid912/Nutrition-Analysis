package com.example.android.nutritionanalysis.di

import com.example.android.nutritionanalysis.pojo.repo.Repository
import com.example.android.nutritionanalysis.pojo.repo.RepositoryImp
import com.example.android.nutritionanalysis.remote_data.NutritionInterface
import com.example.android.nutritionanalysis.remote_data.repo.NutritionRepo
import com.example.android.nutritionanalysis.remote_data.repo.NutritionRepoInterface
import com.example.android.nutritionanalysis.ui.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_URL = "https://api.edamam.com/api/"

val viewModelModule:Module = module {

    viewModel { DetailsViewModel(repository = get()) }
}
val repositoryModule:Module = module {
    single <NutritionRepoInterface>{
        NutritionRepo(api = get() )
    }
    single<Repository> {
        RepositoryImp(nutritionRepoInterface = get())
    }
}
val nutritionClientModule:Module = module {
    val retrofit: NutritionInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(API_URL)
        .build()
        .create(NutritionInterface::class.java)
    single { retrofit }

}