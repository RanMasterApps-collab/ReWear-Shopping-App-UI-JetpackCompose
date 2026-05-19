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
