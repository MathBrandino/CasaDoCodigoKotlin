package br.com.caelum.casadocodigokotlin.util

import br.com.caelum.casadocodigokotlin.data.repository.LivroRepository
import br.com.caelum.casadocodigokotlin.data.repository.webservice.WebClient

object Injetor {

    private val client: WebClient = WebClient()

    val repository = LivroRepository(client)
}