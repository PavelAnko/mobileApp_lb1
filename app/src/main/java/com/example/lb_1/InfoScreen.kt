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
import com.example.lb_1.model.InfoViewModel

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
    vm: InfoViewModel = viewModel()
) {
    val visible = vm.visible.collectAsState()
    val note = vm.note.collectAsState()

    Row(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Інформація", fontSize = 20.sp, modifier = Modifier.padding(bottom = 6.dp))
            Text(
                text = if (visible.value) "Тут показані додаткові відомості про застосунок і метод Віженера." else note.value,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(horizontalAlignment = Alignment.End) {
            Button(
                onClick = { vm.toggleVisible() },
                modifier = Modifier
                    .width(140.dp)
                    .height(40.dp)
            ) {
                Text(if (visible.value) "Сховати" else "Показати")
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(onClick = { vm.showHelp() }, modifier = Modifier.width(120.dp)) {
                Text("Довідка")
            }
        }
    }
}