@Composable
fun SocialRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {

        Icon(
            painterResource(R.drawable.google),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(36.dp)
        )

        Icon(
            painterResource(R.drawable.facebook),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(36.dp)
        )

        Icon(
            painterResource(R.drawable.twitter),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(36.dp)
        )
    }
}
