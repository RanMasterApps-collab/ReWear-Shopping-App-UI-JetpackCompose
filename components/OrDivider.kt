@Composable
fun OrDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier.weight(1f),
            color = Color.White.copy(alpha = 0.4f),
            thickness = 1.dp
        )

        Text(
            text = "  OR  ",
            color = Color.White,
            fontSize = 12.sp
        )

        Divider(
            modifier = Modifier.weight(1f),
            color = Color.White.copy(alpha = 0.4f),
            thickness = 1.dp
        )
    }
}
