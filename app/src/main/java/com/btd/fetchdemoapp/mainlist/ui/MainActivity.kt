package com.btd.fetchdemoapp.mainlist.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.btd.fetchdemoapp.ui.theme.FetchDemoAppTheme
import com.btd.fetchdemoapp.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.state.collectAsState()

            FetchDemoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainListScreen(uiState)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    FetchDemoAppTheme {
    }
}