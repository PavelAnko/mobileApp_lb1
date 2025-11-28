package com.example.lb_1.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.lb_1.repository.PlaceRepository

class PlaceViewModel : ViewModel() {

    var items by mutableStateOf<List<PlaceListItem>>(emptyList())
        private set

    init {
        items = PlaceRepository.loadTestItems()
    }

    fun addPlace(place: Place) {
        items = items + PlaceListItem.PlaceItem(place)
    }

    fun addEvent(event: Event) {
        items = items + PlaceListItem.EventItem(event)
    }

    fun clearAll() {
        items = emptyList()
    }
}
