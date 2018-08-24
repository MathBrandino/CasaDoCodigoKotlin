package br.com.caelum.casadocodigokotlin.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.casadocodigokotlin.data.repository.LivroRepository

class LivroViewModel(private val repository: LivroRepository) : ViewModel() {


    fun lista() = repository.livros

    fun erro() = repository.erro

    fun buscaLivros(){
        repository.buscaLivros()
    }

}