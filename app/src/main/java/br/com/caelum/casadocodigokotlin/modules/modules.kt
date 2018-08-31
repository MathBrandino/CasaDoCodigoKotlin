package br.com.caelum.casadocodigokotlin.modules

import br.com.caelum.casadocodigokotlin.data.repository.LivroRepository
import br.com.caelum.casadocodigokotlin.data.repository.webservice.WebClient
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val repository: Module = module {
    single { LivroRepository(get()) }
}

private val webClientModule: Module = module {
    val url = "http://cdcmob.herokuapp.com/"

    single { WebClient(get()) }
    single {
        Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}

private val viewmodels: Module = module {
    viewModel { LivroViewModel(get()) }
}

val modules = listOf(webClientModule, viewmodels, repository)
