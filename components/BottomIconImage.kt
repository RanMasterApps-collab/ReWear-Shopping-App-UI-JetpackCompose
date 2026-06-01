@Composable
fun BottomIconImage(
    selected: Boolean,
) {

    val icon = if (selected)
        R.drawable.home
    else
        R.drawable.hanger

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.White)
  ,
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}
