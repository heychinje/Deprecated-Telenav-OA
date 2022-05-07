package com.telenav.oa.ui

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import com.telenav.oa.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
//        val imagePainter = rememberImagePainter(
//            data = Uri.parse("android.resource://com.telenav.oa/drawable/login_bg"),
//            builder = {
//                transformations(BlurTransformation(LocalContext.current,radius = 20f))
//            }
//        )
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "Login Screen Background",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
        ) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.login_form_bg),
                contentDescription = "Login Form Background",
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(15.dp)
                    .shadow(10.dp)
                    .border(width = 1.dp, color = MaterialTheme.colors.secondary, RectangleShape)
                    .background(MaterialTheme.colors.background)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row {
                        var userName by remember { mutableStateOf("") }
                        TextField(
                            value = userName,
                            onValueChange = { userName = it },
                            label = { Text(text = "用户名") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MaterialTheme.colors.background
                            )
                        )
                    }
                    Row {
                        var password by remember { mutableStateOf("") }
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "密码") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MaterialTheme.colors.background
                            )
                        )
                    }

                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "登录")
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}