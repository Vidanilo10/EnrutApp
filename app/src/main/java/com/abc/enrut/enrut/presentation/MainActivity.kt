package com.abc.enrut.enrut.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abc.enrut.enrut.presentation.theme.EnrutTheme
import com.abc.enrut.enrut.presentation.view.CompanyApp
import com.abc.enrut.enrut.presentation.view.UserApp

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnrutTheme {
                CompanyApp()
            }
        }
    }
}
