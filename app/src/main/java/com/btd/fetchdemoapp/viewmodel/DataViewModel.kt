package com.btd.fetchdemoapp.viewmodel

import androidx.lifecycle.viewModelScope
import com.btd.fetchdemoapp.DataRepository
import com.btd.fetchdemoapp.SortUtils
import com.btd.fetchdemoapp.common.BaseViewModel
import com.btd.fetchdemoapp.mainlist.ui.state.DataListUiState
import com.btd.fetchdemoapp.model.ApiResponseError
import com.btd.fetchdemoapp.model.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val repository: DataRepository
) :
    BaseViewModel<DataListUiState>(DataListUiState()) {

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = async { repository.getData() }.await()
                when (response) {
                    is Success -> { setState { copy(data = SortUtils.sortList(response.data), hasError = false) }  }
                    is ApiResponseError -> { setState { copy(hasError = true, errorMessage = errorMessage) } }
                }

            } catch (e: Exception) {
                setState { copy(hasError = true, errorMessage = e.message) }
            }
        }
    }

}