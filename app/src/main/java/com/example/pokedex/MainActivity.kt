package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                Pokemon()
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pokemon() {

    Column {

        Box(modifier = Modifier
            .background(Color(0xFFf7a060))
            .border(2.dp, Color(0xFFf7a060), CircleShape)) {
            Image(
                painter = painterResource(id = R.drawable.charizard),
                contentDescription = "charizard",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            )
        }

        Text(
            text = "Charizard", color = Color.White, fontSize = 33.sp, modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(20.dp)
        )

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(35.dp)) {
                    Text(text = "prueba",fontSize = 14.sp)
                }

                Text(
                    text = "90.5 Kg",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.padding(10.dp)
                )

                Text(
                    text = "Weight",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(10.dp)
                )


            }

            Spacer(modifier = Modifier.size(10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(35.dp)) {
                    Text(text = "prueba",fontSize = 14.sp)
                }

                Text(
                    text = "1.7 M",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.padding(10.dp)
                )

                Text(
                    text = "Height",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(10.dp)
                )
            }

        }

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Base Stats",fontSize = 24.sp,color = Color.White)
        }

        Column (modifier = Modifier.padding(40.dp)){
            Row {
                Text(text = "HP",fontSize = 14.sp,color = Color.Gray)
                Spacer(modifier = Modifier.padding(10.dp))
                LinearProgressIndicator(0.5f,color = Color.Red)
            }
            Row {
                Text(text = "ATK",fontSize = 14.sp,color = Color.Gray)
                Spacer(modifier = Modifier.padding(10.dp))
                LinearProgressIndicator(0.5f,color = Color.Yellow)
            }
            Row {
                Text(text = "DEF",fontSize = 14.sp,color = Color.Gray)
                Spacer(modifier = Modifier.padding(10.dp))
                LinearProgressIndicator(0.5f,color = Color.Blue)
            }
            Row {
                Text(text = "SPD",fontSize = 14.sp,color = Color.Gray)
                Spacer(modifier = Modifier.padding(10.dp))
                LinearProgressIndicator(0.5f,color = Color.Gray)
            }
            Row {
                Text(text = "EXP",fontSize = 14.sp,color = Color.Gray)
                Spacer(modifier = Modifier.padding(10.dp))
                LinearProgressIndicator(0.5f,color = Color.Green)
            }

        }



    }
}
