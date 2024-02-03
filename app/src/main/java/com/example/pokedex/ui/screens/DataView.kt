package com.example.pokedex.ui.screens

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
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonTypes

@Composable
fun DataTypeTwo(weight: Float, height: Float, buttonOne:String, buttonTwo:String, pokemon : Pokemon,pokemonTypes: PokemonTypes){
    var color1 = pokemonTypes.type1(pokemon)
    var color2 = pokemonTypes.type2(pokemon)
    var wiightP = weight/10
    var heightP = height/10
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
                Text(text = buttonOne.uppercase(), fontSize = 14.sp)
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
                Text(text = buttonTwo.uppercase(), fontSize = 14.sp)
            }
        }

        Row{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {
                Text(
                    text = "$wiightP KG",
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
                    text = "$heightP M",
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
fun DataTypeOne(weight: Float, height: Float, buttonOne:String, pokemon : Pokemon,pokemonTypes: PokemonTypes){
    var color1 = pokemonTypes.type1(pokemon)
    var wiightP = weight/10
    var heightP = height/10
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
                Text(text = buttonOne.uppercase(), fontSize = 14.sp)
            }
        }

        Row{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )  {
                Text(
                    text = "$wiightP KG",
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
                    text = "$heightP M",
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

