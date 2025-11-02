package com.example.lb_1.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlaceViewModel : ViewModel() {
    private val _clicks = MutableStateFlow(0)
    val clicks = _clicks.asStateFlow()

    private val _label = MutableStateFlow("Натисніть кнопку для отримання позиції")
    val label = _label.asStateFlow()

    fun onUpdatePosition() {
        _clicks.value = _clicks.value + 1
        _label.value = "Оновлено: натиснень ${_clicks.value} — позиція оновлена"
    }

    fun onReset() {
        _clicks.value = 0
        _label.value = "Позицію скинуто"
    }
}
