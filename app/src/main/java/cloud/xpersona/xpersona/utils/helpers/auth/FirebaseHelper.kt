package cloud.xpersona.xpersona.utils.helpers.auth

import cloud.xpersona.xpersona.data.models.auth.AuthStatus
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await

suspend fun getFirebaseResponse(
    auth: FirebaseAuth,
    credential: GoogleIdTokenCredential
): AuthStatus {
    val firebaseCredential = GoogleAuthProvider.getCredential(credential.idToken, null)
    var response: AuthStatus = AuthStatus.None

    firebaseCredential.let {
        auth.signInWithCredential(firebaseCredential)
            .addOnSuccessListener {
                response = AuthStatus.SignedIn
            }
            .addOnFailureListener { e->
                response = AuthStatus.GotException(exception = e)
            }
            .await()
    }

    return response
}

fun checkIfSignedIn(auth: FirebaseAuth): Boolean {
    val user = auth.currentUser
    return user != null
}

fun signOut(auth: FirebaseAuth) {
    auth.signOut()
}