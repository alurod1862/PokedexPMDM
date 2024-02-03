package com.example.pokedex.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

 @Composable
    fun statGeneric(name: String,color: Long,progressIndicator:Float){
        Row(modifier = Modifier.padding(7.dp)) {
            Text(text = name,fontSize = 14.sp,color = Color.Gray)
            Spacer(modifier = Modifier.padding(10.dp))
            LinearProgressIndicator(progressIndicator,color = Color(color), modifier = Modifier
                .width(250.dp)
                .height(20.dp)
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .border(1.dp, Color(0xFF222020))
            )
        }
    }

@Composable
fun statGeneric2(name: String,color: Long,progressIndicator:Float){
    Row(modifier = Modifier.padding(7.dp)) {
        Text(text = name,fontSize = 14.sp,color = Color.Gray)
        Spacer(modifier = Modifier
            .padding(10.dp)
            .width(8.dp))
        LinearProgressIndicator(progressIndicator,color = Color(color), modifier = Modifier
            .width(250.dp)
            .height(20.dp)
            .clip(
                RoundedCornerShape(20.dp)
            )
            .border(1.dp, Color(0xFF222020))
        )
    }
}

