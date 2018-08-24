package br.com.caelum.casadocodigokotlin.data.repository

import android.arch.lifecycle.MutableLiveData
import br.com.caelum.casadocodigokotlin.data.model.Livro
import br.com.caelum.casadocodigokotlin.data.repository.webservice.WebClient

class LivroRepository(private val client: WebClient) {


    val livros: MutableLiveData<List<Livro>> = MutableLiveData()

    val erro: MutableLiveData<Throwable> = MutableLiveData()

    fun buscaLivros() {
        client.lista(sucesso, problema)
    }

    private val sucesso = { lista: List<Livro>? ->
        {
            this.livros.value = lista
        }
    }

    private val problema = { problema: Throwable ->
        {
            this.erro.value = problema
        }
    }
}