
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WishlistScreen() {

    val bgGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF081B33),
            Color(0xFF102A43),
            Color(0xFF1A365D)
        )
    )

    val wishlistItems = listOf(
        WishlistItem("Brown Jacket", 89.0, R.drawable.card1),
        WishlistItem("Stylish Coat", 120.0, R.drawable.card2),
        WishlistItem("White Sneakers", 150.0, R.drawable.card4),
        WishlistItem("Leather Bag", 99.0, R.drawable.bag),
        WishlistItem("Black Hoodie", 79.0, R.drawable.hoodie),
        WishlistItem("Classic Shoes", 135.0, R.drawable.shoe)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgGradient)
    ) {

        Column {
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Wishlist ❤️",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    start = 20.dp,
                    top = 20.dp
                )
            )

            Text(
                text = "${wishlistItems.size} Saved Items",
                color = Color.LightGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(
                    start = 20.dp,
                    top = 4.dp,
                    bottom = 16.dp
                )
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                items(wishlistItems.size) { index ->

                    WishlistCard(
                        item = wishlistItems[index]
                    )
                }
            }
    }}
}
