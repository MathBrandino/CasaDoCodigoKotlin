package br.com.caelum.casadocodigokotlin.data.repository.webservice

import br.com.caelum.casadocodigokotlin.data.dto.Livros
import br.com.caelum.casadocodigokotlin.data.model.Livro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

class WebClient(private val client: Retrofit) {


    fun lista(sucesso: (List<Livro>?) -> () -> Unit, erro: (Throwable) -> () -> Unit) {

        val service = client.create(LivroService::class.java)

        service.buscaLivros().enqueue(object : Callback<Livros> {
            override fun onFailure(call: Call<Livros>, t: Throwable) {
                erro(t)()
            }

            override fun onResponse(call: Call<Livros>, response: Response<Livros>) {
                sucesso(response.body()!!.livros)()
            }
        })
    }


    private interface LivroService {

        @GET("listarLivros?qtdLivros=20&indicePrimeiroLivro=0")
        fun buscaLivros(): Call<Livros>

    }
}