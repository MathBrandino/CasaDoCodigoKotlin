package br.com.caelum.casadocodigokotlin.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


@BindingAdapter("loadFrom")
fun carregaImagem(imageView: ImageView, url: String) {
    val picasso = Picasso.get()

    picasso.setIndicatorsEnabled(true)

    picasso.load(url).placeholder(android.R.drawable.stat_sys_download).fit().into(imageView, object : Callback {
        override fun onSuccess() {

        }

        override fun onError(e: Exception?) {
            picasso.load(android.R.drawable.ic_delete).fit().into(imageView)
        }
    })
}