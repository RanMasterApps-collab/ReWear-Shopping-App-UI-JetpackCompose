
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
val navController = rememberNavController()

NavHost(
    navController = navController,
    startDestination = "splash"
) {

    composable("splash") {
        Mp4SplashScreen(navController)
    }



    composable("login") {

        LoginScreen(
            onSignUpClick = {
                navController.navigate("signup")
            }
        )
    }

    composable("signup") {

        SignUpScreen(
            onLoginClick = {
                navController.navigate("login")
            }
        )
    }

}     }
