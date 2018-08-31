package br.com.caelum.casadocodigokotlin.application

import android.app.Application
import br.com.caelum.casadocodigokotlin.modules.modules
import org.koin.android.ext.android.startKoin

class CasaDoCodigoApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin(this, modules)
    }


}

