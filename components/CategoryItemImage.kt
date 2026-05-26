@Composable
fun CategoryItemImage(
    title: String,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.hanger),
                contentDescription = null,
                contentScale = ContentScale.Crop,
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
