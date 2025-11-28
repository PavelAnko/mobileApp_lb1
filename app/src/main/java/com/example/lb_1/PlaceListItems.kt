package com.example.lb_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lb_1.model.Event
import com.example.lb_1.model.Place
@Composable
fun PlaceListItemView(place: Place, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = "place icon",
                modifier = Modifier.size(40.dp)
            )

            Column(modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxWidth()) {
                Text(text = place.name, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                if (place.address.isNotEmpty()) {
                    Text(text = place.address, style = MaterialTheme.typography.bodySmall)
                }
                Text(text = place.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun EventListItemView(event: Event, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "event icon",
                modifier = Modifier.size(40.dp)
            )

            Column(modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxWidth()) {
                Text(text = event.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = event.date, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = event.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
