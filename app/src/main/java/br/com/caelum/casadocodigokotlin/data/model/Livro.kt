package br.com.caelum.casadocodigokotlin.data.model

import com.google.gson.annotations.SerializedName


data class Livro(val id: Long,
                 @SerializedName("nomeLivro") val nome: String,
                 val descricao: String,
                 val numPaginas: Int,
                 val dataPublicacao: String,
                 val isbn: String,
                 val valorFisico: Double,
                 val valorVirtual: Double,
                 val valorDoisJuntos: Double,
                 val imagemUrl: String)