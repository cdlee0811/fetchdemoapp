package com.btd.fetchdemoapp

import com.btd.fetchdemoapp.model.DataModel

object SortUtils {

    fun sortList(list: List<DataModel>): Map<String, List<DataModel>> {
        return list.filter { it.name != null && it.name.isNotEmpty() }
            .sortedWith(compareBy { it.name }).groupBy { it.listId }.toSortedMap()
    }
}
