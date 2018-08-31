package br.com.caelum.casadocodigokotlin.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.caelum.casadocodigokotlin.data.model.Livro
import br.com.caelum.casadocodigokotlin.databinding.ItemLivroBinding


class LivroAdapter(private val livros: List<Livro>) : Adapter<LivroAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {

        return ViewHolder(ItemLivroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return livros.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, posicao: Int) {

        val livro = livros[posicao]
        viewHolder.bind(livro)
    }


    class ViewHolder(val binding: ItemLivroBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Livro){
            binding.apply {
                livro = item
            }
        }
    }


}


