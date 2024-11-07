package com.btd.fetchdemoapp.mainlist.ui.state

import com.btd.fetchdemoapp.common.UiState
import com.btd.fetchdemoapp.model.DataModel

data class DataListUiState(
    val data: Map<String, List<DataModel>>? = null,
    val hasError: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : UiState