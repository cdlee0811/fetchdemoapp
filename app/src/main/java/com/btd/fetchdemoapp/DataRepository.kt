package com.btd.fetchdemoapp

import com.btd.fetchdemoapp.model.DataModel
import com.btd.fetchdemoapp.model.DataResult

interface DataRepository {
    suspend fun getData(): DataResult<List<DataModel>>
}