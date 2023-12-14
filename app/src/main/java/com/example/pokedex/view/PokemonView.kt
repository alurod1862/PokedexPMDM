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
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.pokedex.R
import com.example.pokedex.logic.PokedexViewModel
import com.example.pokedex.logic.Pokemon
import com.example.pokedex.logic.PokemonType
import com.example.pokedex.logic.type1
import com.example.pokedex.logic.type2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonView(pokedexViewModel: PokedexViewModel) {


    val pokemon by pokedexViewModel.pokemonLiveData.observeAsState(initial = Pokemon())


    Column {

        Spacer(modifier = Modifier.height(60.dp))

        //Imagen pokemon

        var color1 = type1(pokemon)
        var color2 = type2(pokemon)
        val imagen = pokemon.imagen
        val placeholderResource = R.drawable.loading


        Box(modifier = Modifier
            .background(color = color1)
            .border(2.dp, color = color1, CircleShape)) {
            Image(
                painter = rememberImagePainter(
                    data = imagen,
                    builder = {
                        crossfade(true) // Animación de transición al cargar la imagen
                        placeholder(placeholderResource) // Recurso de carga
                    }
                ),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            )
        }

        //Nombre pokemon

        Text(
            text = "${pokemon.name}", color = Color.White, fontSize = 33.sp, modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(20.dp)
        )


        //Peso,altura y tipo de pokemon

        //-----------------------------------------------------------Logica---------------------------------------------------

        //Dependiendo del tipo de pokemon puede ser de un tipo de o de dos

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
                if (pokemon.type2 != null){
                    pokemon.type2?.let { DataTypeTwo(pokemon.weight,pokemon.height,pokemon.type1,it,pokemon) }
                }else{
                    DataTypeOne(pokemon.weight,pokemon.height,pokemon.type1,pokemon)
            }
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
            statGeneric2(name = "HP", color = 0xFFc34749, progressIndicator = pokemon.statHP/255)
            statGeneric(name = "ATK", color = 0xFFf1a948,progressIndicator = pokemon.statATK/255)
            statGeneric(name = "DEF", color = 0xFF3f8ee1,progressIndicator = pokemon.statDEF/255)
            statGeneric(name = "SPD", color = 0xFF96aec3,progressIndicator = pokemon.statSPD/255)
            statGeneric2(name = "SD", color = 0xFF508a47,progressIndicator = pokemon.statSD/255)
            statGeneric2(name = "SA", color = 0xFFA0Ba07,progressIndicator = pokemon.statSA/255)
        }
    }
}


