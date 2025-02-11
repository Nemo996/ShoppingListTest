package com.example.shoppinglist.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shoppinglist.model.ShoppingItem

@Composable
fun ListItem(
    onClick: (Int) -> Unit,
    item: ShoppingItem,
    ordered: Boolean
) {
    Card(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
        .height(50.dp)
        .clickable { onClick(item.id) }) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()) {
            Checkbox(
                checked = ordered,
                onCheckedChange = { onClick(item.id) })
            Text(
                text = item.name,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = item.aisleNumber.toString(),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "",
                modifier = Modifier.size(30.dp, 30.dp).padding(horizontal = 16.dp)
            )
        }
    }
}