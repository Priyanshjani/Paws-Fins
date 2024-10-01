package com.example.sampleapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LogInScreen(navController: NavController){
        val (email,setEmail) = remember { mutableStateOf("") }
        val (passWord,setPassWord) = remember { mutableStateOf("") }
    Wrapper {
        Text(text = "LOGO", style = TextStyle(
            fontSize = 28.sp,
            color = Color(0xFF526EA3),
            fontWeight = FontWeight.Bold,
        ))
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Sign in".uppercase(), style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp
            ), modifier = Modifier
                .drawBehind {
                    val strokeWidth = 20f
                    val y = size.height + strokeWidth / 2
                    drawLine(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFBBD4F6),
                                Color(0xFF4567F8)
                            )
                        ),
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                })
            Spacer(modifier = Modifier.height(18.dp))
            Text(text = "Enter your email and password")
            Spacer(modifier = Modifier.height(42.dp))
            Column {


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx() // Adjust the stroke width as needed
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = strokeWidth
                            )
                        }
                ) {
                    TextField(
                        value = passWord,
                        onValueChange = { setPassWord(it) },
                        label = { Text(text = "Email") },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "avatarIcon"
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            cursorColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = strokeWidth
                            )
                        }
                ) {
                    TextField(
                        value = email,
                        onValueChange = { setEmail(it) },
                        label = { Text(text = "Password") },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "avatarIcon"
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            cursorColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
                ClickableText(text = AnnotatedString("Forgot password?"), style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                ) { offset ->
                    println("Clicked at offset $offset")
                }
                Spacer(modifier = Modifier.height(18.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color(0xFFBBD4F6),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(text = "sign in".uppercase(), style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))
                }
                Spacer(modifier = Modifier.height(18.dp))
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Don’t have an Account?",style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 22.sp
                    ) )
                    Text(text = "Sign Up", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 22.sp,
                        color = Color(0xFF2E20C9),
                        textDecoration = TextDecoration.Underline
                    ), modifier = Modifier.padding(start = 2.dp).clickable { navController.navigate("SignUpScreen") }
                    )
                }
            }
        }
        }
    }
