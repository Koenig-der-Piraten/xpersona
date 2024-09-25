package cloud.xpersona.xpersona.ui.screens.auth

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cloud.xpersona.xpersona.data.models.auth.AuthStatus
import cloud.xpersona.xpersona.utils.helpers.auth.checkIfSignedIn
import cloud.xpersona.xpersona.utils.helpers.auth.getCredentialResponse
import cloud.xpersona.xpersona.utils.helpers.auth.getFirebaseResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class AuthViewModel(private val auth: FirebaseAuth) : ViewModel() {
    private val _authState = mutableStateOf<AuthStatus>(AuthStatus.None)
    val authState get() = _authState

    init {
        if (checkIfSignedIn(auth)) {
            _authState.value = AuthStatus.SignedIn
        }
    }

    fun signInWithGoogle(ctx: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            _authState.value = async {
                getCredentialResponse(ctx)
            }.await()

            if (authState.value is AuthStatus.GotCredential) {
                val credential = (authState.value as AuthStatus.GotCredential).credential
                _authState.value = getFirebaseResponse(auth = auth, credential = credential)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}