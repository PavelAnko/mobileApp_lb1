package com.example.lb_1.model

data class Place(
    val id: Long,
    val name: String,
    val address: String,
    val rating: Float,
    val description: String = ""
)

data class Event(
    val id: Long,
    val title: String,
    val date: String,
    val description: String
)

sealed class PlaceListItem {
    data class PlaceItem(val place: Place) : PlaceListItem()
    data class EventItem(val event: Event) : PlaceListItem()
}