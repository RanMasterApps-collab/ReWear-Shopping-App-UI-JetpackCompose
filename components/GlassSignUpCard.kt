@Composable
fun GlassSignUpCard(
    onLoginClick: () -> Unit = {}
) {

    var termsChecked by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

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

        GlassTextField("Full Name")

        Spacer(modifier = Modifier.height(12.dp))

        GlassTextField("Email Address")

        Spacer(modifier = Modifier.height(12.dp))

        GlassPasswordField(
            hint = "Password",
            passwordVisible = passwordVisible,
            onToggleVisibility = { passwordVisible = !passwordVisible }
        )

        Spacer(modifier = Modifier.height(12.dp))

        GlassPasswordField(
            hint = "Confirm Password",
            passwordVisible = confirmPasswordVisible,
            onToggleVisibility = { confirmPasswordVisible = !confirmPasswordVisible }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Terms & Privacy Checkbox
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = termsChecked,
                onCheckedChange = { termsChecked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White.copy(alpha = 0.7f),
                    uncheckedColor = Color.White.copy(alpha = 0.7f),
                    checkmarkColor = Color.Black
                )
            )

            Text(
                text = "I agree to Terms & Privacy Policy",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        GlassSignUpButton()

        Spacer(modifier = Modifier.height(18.dp))

        OrDivider()

        Spacer(modifier = Modifier.height(18.dp))

        SocialRow()

        Spacer(modifier = Modifier.height(20.dp))

        // Login Text
        Row {
            Text(
                text = "Already have an account? ",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 13.sp
            )

            Text(
                text = "Login",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onLoginClick() }
            )
        }
    }
}
