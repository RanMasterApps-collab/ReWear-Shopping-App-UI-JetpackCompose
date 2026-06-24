
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartScreen(onCheckoutClick:(Double) -> Unit) {
    val context = LocalContext.current
    val bgGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF081B33),
            Color(0xFF102A43),
            Color(0xFF1A365D)
        )
    )

    val cartItems = remember {
        mutableStateListOf(
            CartItem("Brown Jacket", 89.0, 1, R.drawable.card1),
            CartItem("Stylish Coat", 120.0, 2, R.drawable.card2),
            CartItem("Sneakers", 150.0, 1, R.drawable.card4),
            CartItem("Leather Bag", 99.0, 1, R.drawable.bag)
        )
    }

    val totalPrice = cartItems.sumOf {
        it.price * it.quantity
    }

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            CartBottomSection(totalPrice, onCheckout = {
                onCheckoutClick(totalPrice)

                /*Toast.makeText(
                    context,
                    "Proceeding to Checkout...",
                    Toast.LENGTH_SHORT
                ).show()*/
            })

        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(bgGradient)
                .padding(padding)
        ) {

            item {

                Text(
                    text = "My Cart",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 12.dp
                    )
                )
            }

            items(cartItems) { item ->

                CartItemCard(
                    item = item,
                    onIncrease = {
                        item.quantity++
                    },
                    onDecrease = {
                        if (item.quantity > 1) {
                            item.quantity--

                        }
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}
