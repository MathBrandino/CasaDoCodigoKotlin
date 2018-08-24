package br.com.caelum.casadocodigokotlin.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigokotlin.databinding.FragmentErroBinding
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModelFactory

class ErroFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val erroBinding = FragmentErroBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProviders.of(activity!!, LivroViewModelFactory).get(LivroViewModel::class.java)

        erroBinding.error = viewModel.erro().value!!

        return erroBinding.root

    }

}
