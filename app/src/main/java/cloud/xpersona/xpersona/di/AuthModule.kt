package cloud.xpersona.xpersona.di

import cloud.xpersona.xpersona.ui.screens.auth.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel<AuthViewModel> { AuthViewModel() }
}