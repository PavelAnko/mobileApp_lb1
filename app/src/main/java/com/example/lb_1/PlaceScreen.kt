package com.example.lb_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lb_1.model.PlaceViewModel

@Composable
fun PlaceScreen(
    modifier: Modifier = Modifier,
    vm: PlaceViewModel = viewModel()
) {
    val labelText = vm.label.collectAsState()

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Місцезнаходження",
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        Button(
            onClick = { vm.onUpdatePosition() },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(56.dp)
        ) {
            Text(text = "Оновити позицію")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = labelText.value, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(8.dp))

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(onClick = { vm.onReset() }) {
            Text("Скинути")
        }
    }
}