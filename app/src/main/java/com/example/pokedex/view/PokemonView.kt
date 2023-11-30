package com.example.pokedex.view

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.R
import com.example.pokedex.logic.PokedexViewModel
import com.example.pokedex.logic.Pokemon
import com.example.pokedex.logic.PokemonViewModel
import androidx.compose.runtime.livedata.observeAsState



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonView(pokemonViewModel: PokemonViewModel) {

    val name by pokemonViewModel.pokemonName.observeAsState(initial = "")


    Column {

        Spacer(modifier = Modifier.height(60.dp))

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

        //-----------------------------------------------------------Logica---------------------------------------------------

        //Dependiendo del tipo de pokemon puede ser de un tipo de o de dos

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            DataTypeTwo(pokemon.weight,pokemon.height,pokemon.type1,pokemon.type2)
        }

        //-----------------------------------------------------------Logica---------------------------------------------------


        Spacer(modifier = Modifier.size(10.dp))


        //Stats

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Base Stats",fontSize = 24.sp,color = Color.White)
        }


        //Parte inferiror stats del pokemon
        Column (
            modifier = Modifier
                .width(500.dp)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            statHP(name = "HP", color = 0xFFc34749, progressIndicator = pokemon.statHP)
            statGeneric(name = "ATK", color = 0xFFf1a948,progressIndicator = pokemon.statATK)
            statGeneric(name = "DEF", color = 0xFF3f8ee1,progressIndicator = pokemon.statDEF)
            statGeneric(name = "SPD", color = 0xFF96aec3,progressIndicator = pokemon.statSPD)
            statGeneric(name = "EXP", color = 0xFF508a47,progressIndicator = pokemon.statEXP)

        }
    }
}



