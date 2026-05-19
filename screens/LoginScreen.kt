import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onSignUpClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg_for_login),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Glass Card Center
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 170.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            GlassLoginCard(onSignUpClick = onSignUpClick)
        }
    }
}
@Composable
fun GlassLoginCard(
    onSignUpClick: () -> Unit = {}
) {

    var rememberMe by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White.copy(alpha = 0.15f))
            .border(
                1.dp,
                Color.White.copy(alpha = 0.3f),
                RoundedCornerShape(30.dp)
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        // Email Field
        GlassTextField(hint = "Email or username")

        Spacer(modifier = Modifier.height(12.dp))

        // Password Field with Eye Icon
        GlassPasswordField(
            hint = "Password",
            passwordVisible = passwordVisible,
            onToggleVisibility = { passwordVisible = !passwordVisible }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Remember Me + Forgot Password
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White.copy(alpha = 0.7f),
                    uncheckedColor = Color.White.copy(alpha = 0.7f),
                    checkmarkColor = Color.Black
                )
            )

            Text(
                text = "Remember me",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Forgot password?",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        GlassLoginButton()

        Spacer(modifier = Modifier.height(18.dp))

            // Divider OR
            OrDivider()

            Spacer(modifier = Modifier.height(18.dp))

            SocialRow()

            Spacer(modifier = Modifier.height(20.dp))

            // Sign Up Text
            Row {
                Text(
                    text = "Don't have an account? ",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 13.sp
                )

                Text(
                    text = "Sign up",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onSignUpClick() }
                )
            }
        }
}
