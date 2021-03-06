package com.telenav.oa.ui

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.telenav.oa.R
import com.telenav.oa.viewmodel.LoginViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun LoginScreen() {
    val loginViewModel: LoginViewModel = viewModel()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            label = { Text(text = "?????????") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MaterialTheme.colors.background
                            )
                        )
                    }
                    Row {
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "??????") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MaterialTheme.colors.background
                            )
                        )
                    }

                    Button(onClick = {
                        loginViewModel.login(username, password)
                    }) {
                        Text(text = "??????")
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