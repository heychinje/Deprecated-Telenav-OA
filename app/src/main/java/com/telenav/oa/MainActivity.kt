package com.telenav.oa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.telenav.oa.ui.MainScreen
import com.telenav.oa.ui.theme.TelenavOATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelenavOATheme {
                MainScreen()
            }
        }
    }
}