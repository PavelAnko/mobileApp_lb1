package com.example.lb_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lb_1.model.InfoViewModel

object InfoRoutes {
    const val INFO = "info"
    const val DETAILS = "details"
}

@Composable
fun InfoRootScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Box(modifier = modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = InfoRoutes.INFO,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(InfoRoutes.INFO) {
                InfoScreen(
                    modifier = Modifier.fillMaxSize(),
                    onNavigateDetails = { navController.navigate(InfoRoutes.DETAILS) }
                )
            }

            composable(InfoRoutes.DETAILS) {
                SimpleDetailsScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
    vm: InfoViewModel = viewModel(),
    onNavigateDetails: () -> Unit
) {
    val visible by vm.visible.collectAsState(initial = false)
    val note by vm.note.collectAsState(initial = "")

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Інформація", fontSize = 22.sp)

        Spacer(Modifier.height(10.dp))

        Text(
            text = if (visible)
                "Тут показані додаткові відомості про застосунок і метод Віженера."
            else note
        )

        Spacer(Modifier.height(14.dp))

        Button(onClick = { vm.toggleVisible() }) {
            Text(if (visible) "Сховати" else "Показати")
        }

        Spacer(Modifier.height(14.dp))

        Button(onClick = onNavigateDetails) {
            Text("Перейти до деталей")
        }
    }
}

@Composable
fun SimpleDetailsScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Деталі", fontSize = 24.sp)

        Spacer(Modifier.height(20.dp))

        Text("Це довільний другий підекран для другої лабораторної роботи.")

        Spacer(Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text("Назад")
        }
    }
}
