package com.example.mobile_lb1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.lb_1.InfoScreen
import com.example.lb_1.PlaceScreen
import com.example.lb_1.ui.theme.Lb_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lb_1Theme {
                Lb_1App()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun Lb_1App() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = { Icon(it.icon, contentDescription = it.label) },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
                when (currentDestination) {
                    AppDestinations.HOME -> Greeting(name = "Android", modifier = Modifier.fillMaxSize())
                    AppDestinations.PLACE -> PlaceScreen(modifier = Modifier.fillMaxSize())       // from PlaceScreen.kt
                    AppDestinations.INFO -> InfoScreen(modifier = Modifier.fillMaxSize())         // from InfoScreen.kt
                }
            }
        }
    }
}

enum class AppDestinations(val label: String, val icon: ImageVector) {
    HOME("Home", Icons.Default.Home),
    PLACE("Place", Icons.Default.Place),
    INFO("Info", Icons.Default.Info),
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = androidx.compose.ui.Alignment.Center) {
        Text(text = "Hello $name!", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lb_1Theme { Greeting("Android") }
}
