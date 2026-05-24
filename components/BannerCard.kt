// BANNER CARD

                       Card(
                           modifier = Modifier
                               .fillMaxWidth()
                               .height(200.dp),
                           shape = RoundedCornerShape(28.dp),
                           colors = CardDefaults.cardColors(
                               containerColor = Color(0xFF112240)
                           )
                       ) {

                           Box {

                               // PUT YOUR CANVA IMAGE HERE

                               Image(
                                   painter = painterResource(id = R.drawable.banner1),
                                   contentDescription = null,
                                   contentScale = ContentScale.Crop,
                                   modifier = Modifier.fillMaxSize()
                               )

                               Box(
                                   modifier = Modifier
                                       .matchParentSize()
                                       .background(
                                           Brush.horizontalGradient(
                                               colors = listOf(
                                                   Color(0xFF0A1931).copy(alpha = 0.95f),
                                                   Color.Transparent
                                               )
                                           )
                                       )
                               )

                               Column(
                                   modifier = Modifier
                                       .padding(24.dp)
                                       .align(Alignment.CenterStart)
                               ) {

                                   Text(
                                       text = "New Collection",
                                       color = Color.White,
                                       fontSize = 28.sp,
                                       fontWeight = FontWeight.Bold
                                   )

                                   Spacer(modifier = Modifier.height(10.dp))

                                   Text(
                                       text = "Discover trendy thrift fashion styles",
                                       color = Color.White.copy(alpha = 0.75f),
                                       fontSize = 14.sp
                                   )

                                   Spacer(modifier = Modifier.height(18.dp))

                                   Button(
                                       onClick = {
                                           Toast.makeText(context,"Click Shop Now",Toast.LENGTH_SHORT).show()
                                       },
                                       colors = ButtonDefaults.buttonColors(
                                           containerColor = goldColor
                                       ),
                                       shape = RoundedCornerShape(14.dp)
                                   ) {

                                       Text(
                                           text = "Shop Now",
                                           color = Color.Black,
                                           fontWeight = FontWeight.Bold
                                       )
                                   }
                               }
                           }
                       }
