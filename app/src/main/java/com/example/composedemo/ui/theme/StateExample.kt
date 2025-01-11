package com.example.composedemo.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class StateExample {


    @Preview
    @Composable
    fun NotificationsPreview() {
        //state hoisting.
        val count = rememberSaveable { mutableStateOf(0) }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(1f)
        ) {
            NotificationCount(count.value, { count.value++ })
            MessageBar(count.value)
        }
    }


    @Composable
    fun NotificationCount(count: Int, increment: () -> Int) {

        Column(
            Modifier.padding(0.dp, 40.dp),
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "this is ${count} notif.")
            Button(onClick = {
//                count++
                increment()
                Log.d("TAG", "NotificationCount: clicked ")
            }) {
                Text(text = "Send notifications")
            }
        }
    }

    @Composable
    fun MessageBar(count: Int) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "",
                    Modifier.padding(4.dp)
                )
                Text(text = "message sent so far $count")

            }

        }
    }

}