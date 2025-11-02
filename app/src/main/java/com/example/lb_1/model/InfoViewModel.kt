package com.example.lb_1.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InfoViewModel : ViewModel() {
    private val _visible = MutableStateFlow(false)
    val visible = _visible.asStateFlow()

    private val _note = MutableStateFlow("Натисніть «Показати», щоб побачити докладніше")
    val note = _note.asStateFlow()

    fun toggleVisible() {
        _visible.value = !_visible.value
        _note.value = if (_visible.value) "Детальна інформація відображається" else "Натисніть «Показати», щоб побачити докладніше"
    }

    fun showHelp() {
        _note.value = "Відкрито довідку"
    }
}
