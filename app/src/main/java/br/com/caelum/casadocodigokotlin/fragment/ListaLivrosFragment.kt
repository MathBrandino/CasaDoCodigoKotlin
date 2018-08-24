package br.com.caelum.casadocodigokotlin.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigokotlin.R
import br.com.caelum.casadocodigokotlin.adapter.LivroAdapter
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModelFactory

class ListaLivrosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val recyclerView = inflater.inflate(R.layout.fragment_lista_livros, container, false) as RecyclerView

        val viewModel = ViewModelProviders.of(activity!!, LivroViewModelFactory).get(LivroViewModel::class.java)

        recyclerView.adapter = LivroAdapter(viewModel.lista().value!!)

        recyclerView.layoutManager = LinearLayoutManager(context)


        return recyclerView

    }

}
