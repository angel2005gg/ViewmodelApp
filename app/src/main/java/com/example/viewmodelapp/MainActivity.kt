package com.example.viewmodelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.viewmodelapp.ui.theme.ViewmodelAppTheme
import com.example.viewmodelapp.screens.PokeAPIApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelAppTheme {
                // Surface container using the 'background' color from the theme
                Surface {
                    PokeAPIApp(navController = rememberNavController())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewmodelAppTheme {
        PokeAPIApp(navController = rememberNavController())
    }
}
