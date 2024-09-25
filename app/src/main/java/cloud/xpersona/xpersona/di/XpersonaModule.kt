package cloud.xpersona.xpersona.di

import org.koin.dsl.module

val xpersonaModule = module {
    includes(authModule)
    includes(firebaseModule)
}