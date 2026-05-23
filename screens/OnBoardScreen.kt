import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardScreen(
    onLoginClick: () -> Unit = {}
) {

    val pages = listOf(
        OnBoardData(
            image = R.drawable.onboard1,
            title = "Shop Smart. Dress Better.",
            desc = "Discover trendy thrift fashion and buy your favorite styles at affordable prices."
        ),
        OnBoardData(
            image = R.drawable.onboard2,
            title = "Buy & Sell Easily",
            desc = "Upload your outfits,connect with buyers,and refresh your wardrobe anytime."
        ),
        OnBoardData(
            image = R.drawable.onboard3,
            title = "Safe & Stylish Shopping",
            desc = "Enjoy smooth browsing,secure checkout,and a modern shopping experience."
        )
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })

    val coroutineScope = rememberCoroutineScope()

    // PREMIUM GOLD COLOR
    val goldColor = Color(0xFFF6B73C)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1931))
    ) {

        HorizontalPager(
            state = pagerState
        ) { page ->

            val item = pages[page]

            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                // FULL IMAGE
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // DARK NAVY OVERLAY
             Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF0A1931).copy(alpha = 0.75f),
                                Color(0xFF0A1931).copy(alpha = 0.45f),
                                Color.Transparent
                            )
                        )
                    )
                    .blur(2.dp)
            )
                // BOTTOM GRADIENT
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color(0xFF081420),
                                    Color(0xFF081420)
                                ),
                                startY = 900f
                            )
                        )
                )

                // GLASS CARD
               Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 30.dp)
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(32.dp)
                        )
                        .clip(RoundedCornerShape(32.dp))
                        .background(
                            Color.White.copy(alpha = 0.10f)
                        )
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(32.dp)
                        )
                        .heightIn(min = 240.dp)
                        .padding(24.dp)
                )
                {

                    // TITLE
                    Text(
                        text = item.title,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(12.dp))

                    // DESCRIPTION
                    Text(
                        text = item.desc,
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 12.5.sp,
                        lineHeight = 24.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                       // modifier = Modifier.fillMaxWidth(0.92f)
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    // DOTS
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        repeat(pages.size) { index ->

                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .width(
                                        if (pagerState.currentPage == index)
                                            22.dp
                                        else
                                            8.dp
                                    )
                                    .height(8.dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (pagerState.currentPage == index)
                                            goldColor
                                        else
                                            Color.White.copy(alpha = 0.30f)
                                    )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // BUTTON
                    Button(
                        onClick = {

                            coroutineScope.launch {

                                // LAST PAGE
                                if (page == pages.lastIndex) {

                                    onLoginClick()

                                } else {

                                    pagerState.animateScrollToPage(page + 1)
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = goldColor
                        ),
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.92f)
                            .height(52.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {

                        Text(
                            text =
                                if (page == pages.lastIndex)
                                    "Get Started"
                                else
                                    "Next",

                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}
