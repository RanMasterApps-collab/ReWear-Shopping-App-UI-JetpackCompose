//for default icons
@Composable
fun BottomIcon(
    icon: ImageVector,
    selected: Boolean,
    goldColor: Color
) {

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(
                if (selected)
                    goldColor
                else
                    Color.Transparent
            ),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (selected) Color.Black else Color.White
        )
    }
}
