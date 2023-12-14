package com.example.pokedex.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.logic.Pokemon
import com.example.pokedex.logic.PokemonType
import com.example.pokedex.logic.type1
import com.example.pokedex.logic.type2

@Composable
fun DataTypeTwo(weight: Float,height: Float,buttonOne:String,buttonTwo:String,pokemon : Pokemon){
    var color1 = type1(pokemon)
    var color2 = type2(pokemon)
    var peso = weight/10
    var altura = height/10
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Row(
        ) {
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(35.dp),
                    colors = ButtonDefaults.textButtonColors(
                    containerColor = color1, contentColor = Color.White
                )
            ) {
                Text(text = buttonOne, fontSize = 14.sp)
            }
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(35.dp),
                    colors = ButtonDefaults.textButtonColors(
                    containerColor = color2, contentColor = Color.White
                )
            ) {
                Text(text = buttonTwo, fontSize = 14.sp)
            }
        }

        Row{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {
                Text(
                    text = "$peso KG",
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

            Spacer(modifier = Modifier.width(80.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {

                Text(
                    text = "$altura M",
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

    }
}

@Composable
fun DataTypeOne(weight: Float,height: Float,buttonOne:String,pokemon : Pokemon){
    var color1 = type1(pokemon)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Row(
        ) {
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .height(35.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = color1, contentColor = Color.White
                )
            ) {
                Text(text = buttonOne, fontSize = 14.sp)
            }
        }

        Row{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {
                Text(
                    text = "$weight KG",
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

            Spacer(modifier = Modifier.width(80.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {

                Text(
                    text = "$height M",
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

    }
}

