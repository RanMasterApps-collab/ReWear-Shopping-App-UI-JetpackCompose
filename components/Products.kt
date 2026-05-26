                        // PRODUCT TITLE

                                               Text(
                                                   text = "Popular Products",
                                                   color = Color.White,
                                                   fontSize = 22.sp,
                                                   fontWeight = FontWeight.Bold
                                               )
                                               Spacer(modifier = Modifier.height(20.dp))

                                               // PRODUCTS

                                               Row {

                                                   ProductCard(
                                                       image = R.drawable.card1,
                                                       title = "Brown Jacket",
                                                       price = "$89",
                                                       goldColor = goldColor
                                                   )

                                                   Spacer(modifier = Modifier.width(16.dp))

                                                   ProductCard(
                                                       image = R.drawable.card2,
                                                       title = "Stylish Coat",
                                                       price = "$120",
                                                       goldColor = goldColor
                                                   )
                                               }
            
