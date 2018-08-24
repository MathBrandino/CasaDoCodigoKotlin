package br.com.caelum.casadocodigokotlin.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.caelum.casadocodigokotlin.R
import br.com.caelum.casadocodigokotlin.fragment.CarregandoFragment
import br.com.caelum.casadocodigokotlin.fragment.ErroFragment
import br.com.caelum.casadocodigokotlin.fragment.ListaLivrosFragment
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            exibe(CarregandoFragment(), false)
        }
        val viewModel = ViewModelProviders.of(this, LivroViewModelFactory).get(LivroViewModel::class.java)

        viewModel.lista().observe(this, Observer { exibe(ListaLivrosFragment(), false) })
        viewModel.erro().observe(this, Observer { exibe(ErroFragment(), false) })
    }

    private fun exibe(fragment: Fragment, empilhado: Boolean) {

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.main_frame, fragment)

        if (empilhado) transaction.addToBackStack(null)

        transaction.commit()
    }
}
