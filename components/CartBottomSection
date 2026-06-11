
@Composable
fun CartBottomSection(
    totalPrice: Double,
    onCheckout: () -> Unit
) {

    Surface(
        shape = RoundedCornerShape(
            topStart = 30.dp,
            topEnd = 30.dp
        ),
        shadowElevation = 20.dp,
        color = Color(0xFF102A43)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .padding(bottom = 30.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Total",
                    color = Color.White,
                    fontSize = 20.sp
                )

                Text(
                    text = "$${String.format("%.0f", totalPrice)}",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = onCheckout,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),

                shape = RoundedCornerShape(30.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFB800)
                )
            ) {

                Text(
                    text = "Proceed To Checkout",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}
