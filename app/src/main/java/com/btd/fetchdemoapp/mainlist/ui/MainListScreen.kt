package com.btd.fetchdemoapp.mainlist.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.btd.fetchdemoapp.mainlist.ui.state.DataListUiState
import com.btd.fetchdemoapp.model.DataModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainListScreen(uiState: DataListUiState) {
    val data = uiState.data
    LazyColumn(
        modifier = Modifier.statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        data?.forEach { (id, items) ->
            stickyHeader {
                ListHeader(title = "List: $id")
            }
            items(items) { dataItem ->
                ListItem(item = dataItem)
            }
        }
    }
}

@Composable
fun ListHeader(title: String) {
    Row(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
    }
}

@Composable
fun ListItem(item: DataModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = item.name)
    }
}