package br.com.caelum.casadocodigokotlin.modules

import br.com.caelum.casadocodigokotlin.data.repository.LivroRepository
import br.com.caelum.casadocodigokotlin.data.repository.webservice.WebClient
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module


private val webClientModule: Module = module {
    single { WebClient() }
    single { LivroRepository(get()) }
}

private val viewmodels: Module = module {
    viewModel { LivroViewModel(get()) }
}

val modules = listOf(webClientModule, viewmodels)
