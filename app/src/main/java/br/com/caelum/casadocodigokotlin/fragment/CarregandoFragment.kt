package br.com.caelum.casadocodigokotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigokotlin.R
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CarregandoFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val viewModel: LivroViewModel by sharedViewModel()

        viewModel.buscaLivros()

        return inflater.inflate(R.layout.fragment_carregando, container, false)
    }
}