package com.example.shoppinglist.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.shoppinglist.MainActivityViewModel
import com.example.shoppinglist.State
import com.example.shoppinglist.usecase.Sorting

@Composable
fun Content(viewModel: MainActivityViewModel = hiltViewModel()) {
    val state: State by viewModel.state.collectAsStateWithLifecycle()
    val notOrdered = state.order.filter { !it.value }
    val ordered = state.order.filter { it.value }
    val subListNotOrdered = state.list.filter { notOrdered.keys.contains(it.id) }
    val subListOrdered = state.list.filter { ordered.keys.contains(it.id) }
    Column() {
        Row(Modifier.fillMaxWidth().padding(16.dp)) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = state.sort == Sorting.ALPHABETIC,
                    onCheckedChange = { viewModel.sortAlphabet() })
                Text(text = "By Alphabet")
            }
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = state.sort == Sorting.AISLE,
                    onCheckedChange = { viewModel.sortAisle() })
                Text(text = "By Aisle")
            }
        }
        LazyColumn(
        ) {
            items(subListNotOrdered.size) { index ->
                ListItem(
                    onClick = viewModel::onClick,
                    item = subListNotOrdered[index],
                    ordered = false
                )
            }
            if (subListOrdered.isNotEmpty()) {
                item { HorizontalDivider() }
            }
            items(subListOrdered.size) { index ->
                ListItem(onClick = viewModel::onClick, item = subListOrdered[index], ordered = true)
            }
        }
    }
}
