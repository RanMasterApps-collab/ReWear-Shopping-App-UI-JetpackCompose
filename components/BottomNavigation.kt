
        // BOTTOM NAVIGATION

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
                .padding(bottom = 30.dp)
                .fillMaxWidth()
                .height(75.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFF091221)),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                BottomIconImage(
                    selected = true,
          
                )
         BottomIcon(
                    icon = Icons.Default.Home,
                    selected = true,
                    goldColor = goldColor
                )

                BottomIcon(
                    icon = Icons.Default.FavoriteBorder,
                    selected = false,
                    goldColor = goldColor
                )

                BottomIcon(
                    icon = Icons.Default.ShoppingCart,
                    selected = false,
                    goldColor = goldColor
                )

                BottomIcon(
                    icon = Icons.Default.Person,
                    selected = false,
                    goldColor = goldColor
                )
            }
        }  
