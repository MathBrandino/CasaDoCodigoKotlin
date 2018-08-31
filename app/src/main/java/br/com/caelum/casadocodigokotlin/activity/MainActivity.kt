package br.com.caelum.casadocodigokotlin.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.caelum.casadocodigokotlin.R
import br.com.caelum.casadocodigokotlin.data.model.Livro
import br.com.caelum.casadocodigokotlin.fragment.CarregandoFragment
import br.com.caelum.casadocodigokotlin.fragment.ErroFragment
import br.com.caelum.casadocodigokotlin.fragment.ListaLivrosFragment
import br.com.caelum.casadocodigokotlin.viewmodel.LivroViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: LivroViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            exibe(CarregandoFragment(), false)
        }

        viewModel.lista().observe(this, observerLista())
        viewModel.erro().observe(this, observerErro())
    }


    override fun onDestroy() {
        super.onDestroy()

        viewModel.lista().removeObserver(observerLista())
        viewModel.erro().removeObserver(observerErro())
    }

    private fun exibe(fragment: Fragment, empilhado: Boolean) {

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.main_frame, fragment)

        if (empilhado) transaction.addToBackStack(null)

        transaction.commit()
    }


    private fun observerErro(): Observer<Throwable> =
            Observer { exibe(ErroFragment(), false) }

    private fun observerLista(): Observer<List<Livro>> =
            Observer { exibe(ListaLivrosFragment(), false) }
}
