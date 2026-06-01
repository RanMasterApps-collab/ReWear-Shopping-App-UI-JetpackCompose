@Composable
fun ProductCard(
    image: Int,
    title: String,
    price: String,
    goldColor: Color
) {

    Card(
        modifier = Modifier
            .width(150.dp)

        ,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.08f)
        )
    ) {

        Column {

            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = price,
                    color = goldColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

