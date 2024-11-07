package com.btd.fetchdemoapp.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel<T : UiState>(initialState: T): ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected fun setState(update: T.() -> T) {
        _state.update { currentState -> currentState.update() }
    }
}

interface UiState