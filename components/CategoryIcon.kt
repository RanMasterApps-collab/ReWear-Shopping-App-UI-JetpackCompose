

                                // CATEGORY TITLE

                               Row(
                                   modifier = Modifier.fillMaxWidth(),
                                   horizontalArrangement = Arrangement.SpaceBetween
                               ) {

                                   Text(
                                       text = "Categories",
                                       color = Color.White,
                                       fontSize = 22.sp,
                                       fontWeight = FontWeight.Bold
                                   )

                                   Text(
                                       text = "See All",
                                       color = goldColor
                                   )
                               }

                               Spacer(modifier = Modifier.height(20.dp))

                               // CATEGORY ROW

                               Row(
                                   modifier = Modifier.fillMaxWidth(),
                                   horizontalArrangement = Arrangement.SpaceBetween
                               ) {

                                   CategoryItemImage(
                                       title = "T-Shirt",
                                   )

                                    CategoryItem(
                                       icon = Icons.Default.Checkroom,
                                       title = "Shirt",
                                       goldColor = goldColor
                                   )

                                   CategoryItem(
                                       icon = Icons.Default.DryCleaning,
                                       title = "Dress",
                                       goldColor = goldColor
                                   )

                                   CategoryItem(
                                       icon = Icons.Default.Face,
                                       title = "Beauty",
                                       goldColor = goldColor
                                   )

                                   CategoryItem(
                                       icon = Icons.Default.ShoppingBag,
                                       title = "Bag",
                                       goldColor = goldColor
                                   )
                              }
