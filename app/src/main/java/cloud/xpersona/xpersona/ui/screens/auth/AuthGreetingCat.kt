package cloud.xpersona.xpersona.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cloud.xpersona.xpersona.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AuthGreetingCat() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.greeting_cat))

    Box(
        modifier = Modifier
            .fillMaxHeight(0.5F)
    ) {
            LottieAnimation(
                modifier = Modifier.align(Alignment.BottomCenter),
                composition = composition,
                iterations = LottieConstants.IterateForever,
                contentScale = ContentScale.FillWidth
            )
    }
}