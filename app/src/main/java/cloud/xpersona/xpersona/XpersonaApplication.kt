package cloud.xpersona.xpersona

import android.app.Application
import android.content.Context
import cloud.xpersona.xpersona.di.xpersonaModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class XpersonaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val ctx: Context = this
        configureKoin(ctx)
    }

    private fun configureKoin(ctx: Context) {
        startKoin {
            androidLogger()
            androidContext(ctx)
            modules(xpersonaModule)
        }
    }
}