package com.example.lb_1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lb_1.model.Place
import com.example.lb_1.model.PlaceListItem
import com.example.lb_1.model.PlaceViewModel

@Composable
fun PlaceScreen(
    modifier: Modifier = Modifier,
    vm: PlaceViewModel = viewModel()
) {
    val items: List<PlaceListItem> = vm.items

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        item {
            Text(text = "Місця та події", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))

            items.forEach { listItem ->
                when (listItem) {
                    is PlaceListItem.PlaceItem -> PlaceListItemView(place = listItem.place)
                    is PlaceListItem.EventItem -> EventListItemView(event = listItem.event)
                    is PlaceListItem.HorizontalPlacesItem -> HorizontalPlaceList(listItem.places)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(text = "Кінець списку", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun HorizontalPlaceList(places: List<Place>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(places, key = { place -> "place-${place.id}" }) { place ->
            Card(
                modifier = Modifier
                    .width(220.dp)
                    .height(140.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = place.name, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = place.address, style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Рейтинг: ${place.rating}")
                }
            }
        }
    }
}
