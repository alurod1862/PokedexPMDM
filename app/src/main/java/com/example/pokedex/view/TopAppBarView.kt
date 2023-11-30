package com.example.pokedex.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarView() {
    TopAppBar(
        title = { Text(text = "Pokedex", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = {/*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, null, tint = Color.White)
            }
        }, actions = {
            IconButton(onClick = {}) {
                Text(text = "#006", color = Color.White)
            }
        }
    )

}