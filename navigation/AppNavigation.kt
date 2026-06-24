import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash",
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(1000)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(1000)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(1000)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        // All composable screens here

        // Splash
        composable("splash") {
            Mp4SplashScreen(navController)
        }

        // Onboarding
        composable("onboard") {
            OnboardingScreen(
                onLoginClick = {
                    navController.navigate("login") {
                        popUpTo("onboard") { inclusive = true }
                    }
                }
            )
        }

        // Login
        composable("login") {
            LoginScreen(
                onSignUpClick = {
                    navController.navigate("signup")
                },
                onLoginClick = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        // Signup
        composable("signup") {
            SignUpScreen(
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }

        // Home
        composable("home") {

            RewearHomeScreen(navController
            )
        }

        // Product Detail
        composable(  route = "product/{productId}"
            ,enterTransition = {
            scaleIn(
                initialScale = 0.8f,
                animationSpec = tween(500)
            ) + fadeIn()
        },

                exitTransition = {
            scaleOut(
                targetScale = 1.1f,
                animationSpec = tween(500)
            ) + fadeOut()
        }) {backStackEntry ->



            val productId =
                backStackEntry.arguments
                    ?.getString("productId")
                    ?.toIntOrNull() ?: 1

            val product =
                 products.find { it.id == productId }

            if (product != null) {
                ProductDetailScreenUI(
                    image = product.image,
                    title = product.title,
                    price = product.price,
                    description = product.description,

                    onAddToCart = {
                        navController.navigate("cart")
                    }
                )
            }

        }

        // Cart
        composable("cart",enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left
            ) + fadeIn()
        }
,
                exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left
            ) + fadeOut()
        }) {
            CartScreen(
                onCheckoutClick = { totalPrice ->
                    navController.navigate("checkout/$totalPrice")
                }
            )
        }
        // Checkout
        composable("checkout/{totalPrice}") { backStackEntry ->

            val totalPrice =
                backStackEntry.arguments?.getString("totalPrice") ?: "0"

            CheckoutScreen(
                totalPrice = totalPrice,
                onPlaceOrder = {
                    navController.navigate("success")
                }
            )
        }
        // Order Success
        composable("success",enterTransition = {
            scaleIn(
                initialScale = 0.5f,
                animationSpec = tween(600)
            )
        },

                exitTransition = {
            scaleOut(
                targetScale = 1.5f,
                animationSpec = tween(600)
            )
        }) {
            OrderSuccessScreen(
                onContinueShopping = {
                    navController.navigate("home") {
                        popUpTo("home")
                    }
                }
            )
        }

        // Profile
        composable("profile") {
            ProfileScreen(
                /*onWishlistClick = {
                    navController.navigate("wishlist")
                }
*/            )
        }

        // Wishlist
        composable("wishlist") {
            WishlistScreen()
        }
    }
}
