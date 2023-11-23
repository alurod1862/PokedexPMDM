package com.example.pokedex.logic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pokemon() {

    Column {

        //Imagen pokemon

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

        //Nombre pokemon

        Text(
            text = "Charizard", color = Color.White, fontSize = 33.sp, modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(20.dp)
        )


        //Peso,altura y tipo de pokemon

        /*Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(10.dp)
                .width(150.dp)
                .height(35.dp)) {
                Text(text = "buttonOne",fontSize = 14.sp)
            }
        }*/

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            DataTypeTwo(90.5f,1.7f,"flying","fire")
            //DataTypeOne(weight = 90.5f,1.7f,"Normal")
        }


        Spacer(modifier = Modifier.size(20.dp))


        //Stats

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Base Stats",fontSize = 24.sp,color = Color.White)
        }


        //Parte inferiror stats del pokemon
        Column (
            modifier = Modifier.padding(40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            //stat(name = "HP", color = 0xFFc34749)
            Row(modifier = Modifier.padding(7.dp)) {
                Text(text = "HP",fontSize = 14.sp,color = Color.Gray)
                Spacer(modifier = Modifier
                    .padding(10.dp)
                    .width(8.dp))
                LinearProgressIndicator(0.5f,color = Color(0xFFc34749), modifier = Modifier
                    .width(250.dp)
                    .height(20.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    )
                    .border(1.dp, Color(0xFF222020))
                )
            }

            stat(name = "ATK", color = 0xFFf1a948)
            stat(name = "DEF", color = 0xFF3f8ee1)
            stat(name = "SPD", color = 0xFF96aec3 )
            stat(name = "EXP", color = 0xFF508a47)

        }
    }
}



