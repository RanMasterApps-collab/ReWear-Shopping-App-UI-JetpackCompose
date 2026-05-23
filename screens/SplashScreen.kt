import androidx.media3.exoplayer.ExoPlayer
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import androidx.media3.common.MediaItem

@Composable
fun Mp4SplashScreen(navController: NavController) {

    val context = LocalContext.current

    val exoPlayer = remember {

        ExoPlayer.Builder(context).build().apply {

            val mediaItem = MediaItem.fromUri(
                Uri.parse("android.resource://${context.packageName}/${R.raw.splash_canva_anim}")
            )

            setMediaItem(mediaItem)

            prepare()

            playWhenReady = true
        }
    }

    // ✅ 3 sec baad navigate
    LaunchedEffect(Unit) {

        delay(4000)

        navController.navigate("login") {

            popUpTo("splash") {
                inclusive = true
            }
        }
    }

    // ✅ Release player
    DisposableEffect(Unit) {

        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = {
            PlayerView(it).apply {

                player = exoPlayer

                useController = false

                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
