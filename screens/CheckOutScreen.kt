package com.ranmasterapp.canva_preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutScreen() {

    var selectedMethod by remember {
        mutableStateOf("Visa")
    }
    var cardHolder by remember {
        mutableStateOf("OLIVIA PARKER")
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
                            text = "Olivia Parker",
                            color = Color.LightGray
                        )

                        Text(
                            text = "Karachi, Pakistan",
                            color = Color.LightGray
                        )
                    }
                }

                Text(
                    text = "Edit",
                    color = yellow,
                    fontWeight = FontWeight.SemiBold
                )
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
                    onValueChange = { cardNumber = it },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 22.sp,
                        letterSpacing = 2.sp
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                BasicTextField(
                    value = cardHolder,
                    onValueChange = { cardHolder = it },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
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
                            onValueChange = { validDate = it },
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
                            onValueChange = { cvv = it },
                            textStyle = TextStyle(
                                color = Color.White
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
                      Text("$240", color = Color.White)
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
                          "$250",
                          color = yellow,
                          fontWeight = FontWeight.Bold
                      )
                  }
              }
          }

        //  Spacer(modifier = Modifier.weight(1f))
          Spacer(modifier = Modifier.height(20.dp))

                  Button(
                      onClick = {},
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
