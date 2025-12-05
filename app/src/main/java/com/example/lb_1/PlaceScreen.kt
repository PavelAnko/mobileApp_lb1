package com.example.lb_1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lb_1.model.PlaceListItem
import com.example.lb_1.model.PlaceViewModel

@Composable
fun PlaceScreen(
    modifier: Modifier = Modifier,
    vm: PlaceViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Місця та події", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(vm.items, key = { item ->
                when (item) {
                    is PlaceListItem.PlaceItem -> "place-${item.place.id}"
                    is PlaceListItem.EventItem -> "event-${item.event.id}"
                }
            }) { item ->
                when (item) {
                    is PlaceListItem.PlaceItem -> PlaceListItemView(place = item.place)
                    is PlaceListItem.EventItem -> EventListItemView(event = item.event)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Кінець списку", style = MaterialTheme.typography.bodySmall)
    }
}
