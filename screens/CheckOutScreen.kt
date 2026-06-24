@Composable
fun CheckoutScreen(totalPrice:String,onPlaceOrder:() -> Unit)
{

    var selectedMethod by remember {
        mutableStateOf("Visa")
    }
    var name by remember {
        mutableStateOf("Olivia Marie")
    }

    var city by remember {
        mutableStateOf("Karachi, Pakistan")
    }
    var tempName by remember { mutableStateOf(name) }
    var tempCity by remember { mutableStateOf(city) }


    var showEdit by remember {
        mutableStateOf(false)
    }
    var cardHolder by remember {
        mutableStateOf("OLIVIA MARIE")
    }

    var cardNumber by remember {
        mutableStateOf("4315 0245 4480 0345")
    }

    var validDate by remember {
        mutableStateOf("12/28")
    }

    var cvv by remember {
        mutableStateOf("456")
    }



    val darkBlue = Color(0xFF0F2E5B)
    val cardBlue = Color(0xFF1A3B6B)
    val yellow = Color(0xFFFFC107)
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Checkout",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Shipping Address",
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardBlue
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row {

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = yellow
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.padding(10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {

                        Text(
                            text = "Home Address",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = name,
                            color = Color.LightGray
                        )

                        Text(
                            text = city,
                            color = Color.LightGray
                        )
                    }
                }

                Text(
                    text = "Edit",
                    color = yellow,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {

                        tempName = name
                        tempCity = city

                        showEdit = true
                    }
                )
            }
        }
        if (showEdit) {

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = tempName,
                onValueChange = { tempName = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = tempCity,
                onValueChange = { tempCity = it },
                label = { Text("Address") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Button(
                    onClick = {
                        name = tempName
                        city = tempCity
                        showEdit = false
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = yellow
                    )
                ) {
                    Text("Save", color = Color.Black)
                }

                Button(
                    onClick = {
                        showEdit = false
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray
                    )
                ) {
                    Text("Cancel")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "🚚",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Estimated Delivery: 2-3 Days",
                color = Color.LightGray,
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

       Text(
            text = "Payment Method",
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Card(
                modifier = Modifier.clickable {
                    selectedMethod = "Visa"
                },
                colors = CardDefaults.cardColors(
                    containerColor =
                        if (selectedMethod == "Visa")
                            yellow
                        else
                            cardBlue
                )
            ) {
                Text(
                    "Visa",
                    modifier = Modifier.padding(12.dp),
                    color =
                        if (selectedMethod == "Visa")
                            Color.Black
                        else
                            Color.White
                )
            }

            Card(
                modifier = Modifier.clickable {
                    selectedMethod = "PayPal"
                },
                colors = CardDefaults.cardColors(
                    containerColor =
                        if (selectedMethod == "PayPal")
                            yellow
                        else
                            cardBlue
                )
            ) {
                Text(
                    "PayPal",
                    modifier = Modifier.padding(12.dp),
                    color =
                        if (selectedMethod == "PayPal")
                            Color.Black
                        else
                            Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Image(
                        painter = painterResource(
                            if (selectedMethod == "Visa")
                                R.drawable.visa_logo
                            else
                                R.drawable.paypal_logo
                        ),
                        contentDescription = null,
                        modifier = Modifier.height(30.dp)
                    )

                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(3.dp))

                Image(
                    painter = painterResource(R.drawable.chip),
                    colorFilter = ColorFilter.tint(
                        Color(0xFFFFC107)
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(30.dp)
                        .padding(end = 10.dp)                )
                Spacer(modifier = Modifier.height(3.dp))

                BasicTextField(
                    value = cardNumber,
                    onValueChange = {

                        val digits = it.filter { char ->
                            char.isDigit()
                        }.take(16)

                        cardNumber = digits.chunked(4).joinToString(" ")
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 22.sp,
                        letterSpacing = 2.sp
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))

                BasicTextField(
                    value = cardHolder,
                    onValueChange = {
                        cardHolder = it.uppercase()
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    ),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Characters
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {

                        Text(
                            text = "VALID THRU",
                            color = Color.Gray,
                            fontSize = 10.sp
                        )

                        BasicTextField(
                            value = validDate,
                            onValueChange = {

                                val digits = it.filter { ch ->
                                    ch.isDigit()
                                }.take(4)

                                validDate = when {
                                    digits.length <= 2 -> digits
                                    else -> digits.substring(0, 2) + "/" +
                                            digits.substring(2)
                                }
                            },
                            textStyle = TextStyle(
                                color = Color.White
                            )
                        )
                    }

                    Column {

                        Text(
                            text = "CVV",
                            color = Color.Gray,
                            fontSize = 10.sp
                        )

                        BasicTextField(
                            value = cvv,
                            onValueChange = {
                                cvv = it.take(3)
                            },
                            textStyle = TextStyle(
                                color = Color.White
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                    }
                }
            }
        }

          Spacer(modifier = Modifier.height(20.dp))

          Card(
              colors = CardDefaults.cardColors(
                  containerColor = cardBlue
              ),
              modifier = Modifier.fillMaxWidth()
          ) {

              Column(
                  modifier = Modifier.padding(16.dp)
              ) {

                  Text(
                      "Order Summary",
                      color = Color.White,
                      fontWeight = FontWeight.Bold
                  )

                  Spacer(modifier = Modifier.height(12.dp))

                  Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement =
                          Arrangement.SpaceBetween
                  ) {
                      Text("Subtotal", color = Color.White)
                   //   val totalPrice = cartItems.sumOf { it.price }
                      Text(totalPrice, color = Color.White)
                  }

                  Spacer(modifier = Modifier.height(8.dp))

                  Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement =
                          Arrangement.SpaceBetween
                  ) {
                      Text("Shipping", color = Color.White)
                      Text("$10", color = Color.White)
                  }

                  Divider(
                      modifier = Modifier.padding(vertical = 12.dp),
                      color = Color.Gray
                  )

                  Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement =
                          Arrangement.SpaceBetween
                  ) {
                      Text(
                          "Total",
                          color = Color.White,
                          fontWeight = FontWeight.Bold
                      )

                      Text(
                          (totalPrice.toDouble()+10.0).toString(),
                          color = yellow,
                          fontWeight = FontWeight.Bold
                      )
                  }
              }
          }

        //  Spacer(modifier = Modifier.weight(1f))
          Spacer(modifier = Modifier.height(20.dp))

                  Button(
                      onClick ={ onPlaceOrder()
        /*
                          Toast.makeText(
                              context,
                              "Order Placed Successfully 🎉",
                              Toast.LENGTH_SHORT
                          ).show()*/
                      },
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(58.dp),
                      colors = ButtonDefaults.buttonColors(
                          containerColor = yellow
                      )
                  ) {

                      Text(
                          "Place Order",
                          color = Color.Black,
                          fontWeight = FontWeight.Bold
                      )
                  }
              }
}
