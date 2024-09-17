package com.example.composeapp.ui.views.messages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapp.R
import com.example.composeapp.repository.entities.MessageData
import com.example.composeapp.utils.DateUtils.parseDate
import com.example.composeapp.utils.ImageUtils
import java.util.Calendar

@Composable
fun MessageListPage() {

    Column(){
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text(text = "Search") },
            leadingIcon = { ImageUtils.showImageDrawable(drawable = R.drawable.ic_search) },
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxWidth()
        )

        LazyColumn {
            MessageListAdapter()
        }
    }
}

@Composable
fun MessageListAdapter(item: MessageData){
    val time = item.lastSeen.parseDate()
    Row(){
        ImageUtils.showImageUrlCrop(modifier = Modifier
            .height(64.dp)
            .width(64.dp),url = "")
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 60.dp)) {
        }
        time?.let {
            Text(text = "${it.get(Calendar.HOUR_OF_DAY)}:${it.get(Calendar.MINUTE)}" +
                    "${it.get(Calendar.AM_PM)}")
        }
    }
}