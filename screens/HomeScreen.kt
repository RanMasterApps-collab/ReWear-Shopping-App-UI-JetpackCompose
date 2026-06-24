
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.DryCleaning
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun RewearHomeScreen(navController:NavController) {
    val goldColor = Color(0xFFF6B73C)
    val bgGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0A1931),
            Color(0xFF1A3D63)
        )
    )


    val context= LocalContext.current
    val selected = true
    val currentRoute =
        navController.currentBackStackEntryAsState()
            .value?.destination?.route
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgGradient)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 120.dp)
                .padding(horizontal = 20.dp),
          //  contentPadding = PaddingValues(bottom = 100.dp)
        ) {

            item {

                Spacer(modifier = Modifier.height(50.dp))


                // TOP BAR


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            text = "Location",
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = goldColor,
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = "Karachi, Pakistan",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.12f)),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // SEARCH BAR

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color.White.copy(alpha = 0.10f))
                            .border(
                                1.dp,
                                Color.White.copy(alpha = 0.12f),
                                RoundedCornerShape(18.dp)
                            )
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 18.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color.White.copy(alpha = 0.7f)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = "Search fashion...",
                                color = Color.White.copy(alpha = 0.5f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Box(
                        modifier = Modifier
                            .size(58.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(goldColor),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Tune,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }

               Spacer(modifier = Modifier.height(28.dp))


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


                       Spacer(modifier = Modifier.height(30.dp))


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
                                                   /*                   CategoryItemImage(
                                       title = "T-Shirt",
                                   )
*/
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
                      Spacer(modifier = Modifier.height(30.dp))



                                               // PRODUCT TITLE

                                               Text(
                                                   text = "Popular Products",
                                                   color = Color.White,
                                                   fontSize = 22.sp,
                                                   fontWeight = FontWeight.Bold
                                               )
                                               Spacer(modifier = Modifier.height(20.dp))

                                               // PRODUCTS

                                             /*  Row (
                                                   modifier = Modifier.horizontalScroll(rememberScrollState())

                                               ){

                                                   ProductCard(
                                                       image = R.drawable.card1,
                                                       title = "Brown Jacket",
                                                       price = "$89",
                                                       goldColor = goldColor
                                                  , onClick = {
                                                           navController.navigate("product")
                                                       } )

                                                   Spacer(modifier = Modifier.width(16.dp))
                                                   ProductCard(
                                                       image = R.drawable.card3,
                                                       title = "Stylish Coat",
                                                       price = "$120",
                                                       goldColor = goldColor
                                                   , onClick = {
                                                           navController.navigate("product")
                                                       })
                                               Spacer(modifier = Modifier.width(16.dp))

                                                   ProductCard(
                                                       image = R.drawable.card4,
                                                       title = "White Sneakers",
                                                       price = "$150",
                                                       goldColor = goldColor
                                                   , onClick = {
                                                           navController.navigate("product")
                                                       })
                                               Spacer(modifier = Modifier.width(16.dp))

                                                   ProductCard(
                                                       image = R.drawable.bag,
                                                       title = "Leather Bag",
                                                       price = "$99",
                                                       goldColor = goldColor
                                                   , onClick = {
                                                           navController.navigate("product")
                                                       })
                                              Spacer(modifier = Modifier.width(16.dp))

                                                   ProductCard(
                                                       image = R.drawable.hoodie,
                                                       title = "Black Hoodie",
                                                       price = "$79",
                                                       goldColor = goldColor
                                                   , onClick = {
                                                           navController.navigate("product")
                                                       })
                                              Spacer(modifier = Modifier.width(16.dp))

                                                   ProductCard(
                                                       image = R.drawable.shoe,
                                                       title = "Classic Shoes",
                                                       price = "$135",
                                                       goldColor = goldColor
                                                   , onClick = {
                                                           navController.navigate("product")
                                                       })
                                               }
            */
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {

                    products.forEach { product ->

                        ProductCard(
                            image = product.image,
                            title = product.title,
                            price = product.price,
                            goldColor = goldColor,
                            onClick = {
                                navController.navigate("product/${product.id}")
                            }
                        )

                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }}
        }






        // BOTTOM NAVIGATION

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
                .padding(bottom = 20.dp)
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
                /*BottomIconImage(
                    selected = true,
                  //  goldColor = goldColor
                )*/
      /*   BottomIcon(
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
                )*/
                BottomIcon(
                    icon = Icons.Default.Home,
                    selected = true,
                    goldColor = goldColor,
                    onClick = {
                        navController.navigate("home")
                    }
                )

                BottomIcon(
                    icon = Icons.Default.FavoriteBorder,
                    selected = false,
                    goldColor = goldColor,
                    onClick = {
                        navController.navigate("wishlist")
                    }
                )

                BottomIcon(
                    icon = Icons.Default.ShoppingCart,
                    selected = false,
                    goldColor = goldColor,
                    onClick = {
                        navController.navigate("cart")
                    }
                )

                BottomIcon(
                    icon = Icons.Default.Person,
                    selected = false,
                    goldColor = goldColor,
                    onClick = {
                        navController.navigate("profile")
                    }
                )}
       }   }
}
