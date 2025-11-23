package com.example.lb_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lb_1.model.InfoViewModel

enum class InfoDestinations {
    MAIN_INFO,
    DETAILS
}

@Composable
fun InfoRootScreen(modifier: Modifier = Modifier) {
    var current by remember { mutableStateOf(InfoDestinations.MAIN_INFO) }

    Box(modifier = modifier.fillMaxSize()) {
        when (current) {
            InfoDestinations.MAIN_INFO -> InfoScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateDetails = { current = InfoDestinations.DETAILS }
            )

            InfoDestinations.DETAILS -> SimpleDetailsScreen(
                onBack = { current = InfoDestinations.MAIN_INFO }
            )
        }
    }
}

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
    vm: InfoViewModel = viewModel(),
    onNavigateDetails: () -> Unit
) {
    val visible = vm.visible.collectAsState()
    val note = vm.note.collectAsState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Інформація", fontSize = 22.sp)

        Spacer(Modifier.height(10.dp))

        Text(
            text = if (visible.value)
                "Тут показані додаткові відомості про застосунок і метод Віженера."
            else note.value
        )

        Spacer(Modifier.height(14.dp))

        Button(onClick = { vm.toggleVisible() }) {
            Text(if (visible.value) "Сховати" else "Показати")
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