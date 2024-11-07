package com.btd.fetchdemoapp.model

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("id") val id: String,
    @SerializedName("listId") val listId: String,
    @SerializedName("name") val name: String
)