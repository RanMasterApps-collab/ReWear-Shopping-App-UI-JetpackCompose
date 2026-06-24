import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderSuccessScreen(onContinueShopping:() -> Unit) {
    val images = listOf(
        R.drawable.card1,
        R.drawable.card2,
        R.drawable.card4,
        R.drawable.bag
    )
    val columns = when {
        images.size <= 1 -> 1
        images.size <= 4 -> 2
        else -> 3
    }
    val darkBlue = Color(0xFF0F2E5B)
    val yellow = Color(0xFFFFC107)
    Column(
        modifier = Modifier.run {
            fillMaxSize()
                .background(darkBlue)
                .padding(24.dp)
                .padding(top = 40.dp)
        },
    ) {
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
            text = "OrderSuccess",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier.run {
            fillMaxSize()
                .background(darkBlue)
                .padding(24.dp)
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


      /*  Box(
            modifier = Modifier
                .size(270.dp)
                .clip(RoundedCornerShape(25.dp))
        ) {
      */      LazyVerticalGrid(
                columns = GridCells.Fixed(columns),
                modifier = Modifier.size(270.dp),
                userScrollEnabled = false
            ) {
                items(images) { image ->
                    Image(
                        painter = painterResource(image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                }
        }
/*
        Image(
            painter = painterResource(R.drawable.card1),//success_illustration
            contentDescription = null,
            modifier = Modifier.size(270.dp)
            .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )

*/
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Order Confirmed!",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Your order has been placed successfully.",
            color = Color.LightGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Order ID: #RW2026",
            color = yellow,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow
            )
        ) {
            Text(
                "Track Order",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = {onContinueShopping()},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Continue Shopping")
        }
    }
}}
