package br.com.caelum.casadocodigokotlin.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigokotlin.R
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModelFactory

class CarregandoFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val viewModel = ViewModelProviders.of(activity!!, LivroViewModelFactory).get(LivroViewModel::class.java)

        viewModel.buscaLivros()

        return inflater.inflate(R.layout.fragment_carregando, container, false)
    }
}