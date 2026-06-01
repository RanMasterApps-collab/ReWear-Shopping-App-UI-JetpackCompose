//for default icons

@Composable
fun CategoryItem(
    icon: ImageVector,
    title: String,
    goldColor: Color
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.10f)),
            contentAlignment = Alignment.Center
        ) {
             Icon(
                imageVector = icon,
                contentDescription = null,
                tint = goldColor,
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = title,
            color = Color.White
        )
    }
}
