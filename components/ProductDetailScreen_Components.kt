

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {}) {
            Icon(Icons.Default.ArrowBack, null, tint = Color.White)
        }

        IconButton(onClick = {}) {
            Icon(Icons.Default.FavoriteBorder, null, tint = Color.White)
        }
    }
}

@Composable
fun ProductImageSection(image: Int) {
    Card(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(310.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun ProductInfoSection(title: String,description: String) {

    Text(
        text = "Female's Style",
        color = Color.White
    )

    Spacer(modifier = Modifier.height(6.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold, color = Color.White
        )

        Rating()
    }

    Spacer(modifier = Modifier.height(5.dp))

    Text(
        text = "Product Details",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp, color = Color.White
    )
    Spacer(modifier = Modifier.height(5.dp))

    Text(
        fontSize = 14.sp,
        color = Color.White,
        text = description )
    Text(
        fontSize = 14.sp,
        color = Color(0xFFF6B73C),
        fontWeight = FontWeight.SemiBold,
        text = "Read More."
    )
}

@Composable
fun Rating() {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            Icons.Default.Star,
            null,
            tint = Color(0xFFFFC107)
        )

        Text(
            color = Color.White, text = "4.5"
        )
    }
}

@Composable
fun SizeSelector() {

    val goldColor = Color(0xFFF6B73C)
    val unSelectedColor = Color(0xFF102847)

    val sizes = listOf("S", "M", "L", "XL")

    var selectedSize by remember {
        mutableStateOf("M")
    }

    LazyRow {

        items(sizes) { size ->

            val isSelected = selectedSize == size

            Box(
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        if (isSelected)
                            goldColor
                        else
                            unSelectedColor
                    )
                    .clickable {
                        selectedSize = size
                    },
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = size,
                    color = if (isSelected)
                        Color.Black
                    else
                        Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun ColorSelector() {

    val goldColor = Color(0xFFF6B73C)

    val colors = listOf(
        Color(0xFFB26B3E), // Brown
        Color(0xFF1A1A1A), // Black
        Color(0xFF2F5D9F), // Blue
        Color(0xFFF5F1E8)  // Cream
    )

    var selectedColor by remember {
        mutableStateOf(colors[0]) // Brown selected by default
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        colors.forEach { color ->

            val isSelected = selectedColor == color

            Box(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(42.dp)
                    .clip(CircleShape)
                    .border(
                        width = if (isSelected) 2.dp else 1.dp,
                        color = if (isSelected)
                            goldColor
                        else
                            Color.White.copy(alpha = 0.15f),

                        shape = CircleShape
                    )
                    .padding(3.dp)
                    .background(
                        color = color,
                        shape = CircleShape
                    )
                    .clickable {
                        selectedColor = color
                    }
            )
        }
    }
}

@Composable
fun BottomPriceBar(price: String,onAddToCart: () -> Unit) {
    val goldColor = Color(0xFFF6B73C)
    BottomAppBar(
        containerColor = Color(0xFF102A43),
        modifier = Modifier
            .height(150.dp)
            .clip(RoundedCornerShape(20.dp))

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(10.dp))

            Column {

                Text(
                    color = Color.White, text = "Total Price"
                )

                Text(
                    price,
                    fontWeight = FontWeight.Bold, color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {onAddToCart()
                },
                modifier = Modifier
                    .width(220.dp)
                    .height(50.dp)
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = goldColor
                )
            ) {

                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    tint = Color.White
                )
                /*Image(
                                painter = painterResource(R.drawable.home),
                                contentDescription = null,
                                modifier = Modifier.size(22.dp)
                            )*/

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Add To Cart",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}
