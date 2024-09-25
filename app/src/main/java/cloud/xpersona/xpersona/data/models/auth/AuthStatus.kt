package cloud.xpersona.xpersona.data.models.auth

import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import java.lang.Exception

sealed class AuthStatus {
    data object None : AuthStatus()

    data object SignedIn : AuthStatus()

    data class GotException(
        val exception: Exception
    ) : AuthStatus()

    data class GotCredential(
        val credential: GoogleIdTokenCredential
    ) : AuthStatus()
}

