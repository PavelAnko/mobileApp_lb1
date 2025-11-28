package com.example.lb_1.repository

import com.example.lb_1.model.Event
import com.example.lb_1.model.Place
import com.example.lb_1.model.PlaceListItem

object PlaceRepository {
    fun loadTestItems(): List<PlaceListItem> {
        val places = listOf(
            Place(id = 1, name = "Парк Шевченка", address = "вул. Центральна, 10", rating = 4.5f),
            Place(id = 2, name = "Кав'ярня Aroma", address = "вул. Лесі, 5", rating = 4.0f),
            Place(id = 3, name = "Музей IT", address = "пр. Науки, 3", rating = 4.8f)
        )

        val events = listOf(
            Event(
                id = 1,
                title = "Фестиваль в парку",
                date = "2025-06-15",
                description = "Музика, їжа, майстер-класи"
            ),
            Event(id = 2, title = "Відкриття виставки", date = "2025-07-01", description = "Сучасне мистецтво та технології")
        )

        val items = mutableListOf<PlaceListItem>()
        items += PlaceListItem.PlaceItem(places[0])
        items += PlaceListItem.EventItem(events[0])
        items += PlaceListItem.PlaceItem(places[1])
        items += PlaceListItem.PlaceItem(places[2])
        items += PlaceListItem.EventItem(events[1])
        return items
    }
}
