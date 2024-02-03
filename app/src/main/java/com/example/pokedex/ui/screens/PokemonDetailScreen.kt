package com.example.pokedex.ui.screens

import android.annotation.SuppressLint
import android.app.Application
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.pokedex.R
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonTypes
import com.example.pokedex.ui.components.MyTopAppBarView
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@coil.annotation.ExperimentalCoilApi
@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PokemonView(pokemonDetailViewModel: PokemonDetailViewModel,pokemonTypes: PokemonTypes,navController: NavController) {

    val pokemon by pokemonDetailViewModel.pokemonLiveData.observeAsState(initial = Pokemon())

    Scaffold(
        topBar = {
            MyTopAppBarView(navController, pokemon.id.toString())
        }
    ) {
        Column {


            Spacer(modifier = Modifier.height(60.dp))

            //Imagen pokemon

            var color1 = pokemonTypes.type1(pokemon)
            var color2 = pokemonTypes.type2(pokemon)
            val imagen = pokemon.imagen
            val placeholderResource = R.drawable.loading


            Box(
                modifier = Modifier
                    .background(color = color1)
                    .border(2.dp, color = color1, CircleShape)
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = imagen,
                        builder = {
                            crossfade(true)
                            placeholder(placeholderResource)
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
                if (pokemon.type2 != null) {
                    pokemon.type2?.let {
                        DataTypeTwo(
                            pokemon.weight,
                            pokemon.height,
                            pokemon.type1,
                            it,
                            pokemon,
                            PokemonTypes()
                        )
                    }
                } else {
                    DataTypeOne(
                        pokemon.weight, pokemon.height, pokemon.type1, pokemon, PokemonTypes()
                    )
                }
            }

            //-----------------------------------------------------------Logica---------------------------------------------------


            Spacer(modifier = Modifier.size(10.dp))


            //Stats

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Base Stats", fontSize = 24.sp, color = Color.White)
            }


            //Parte inferiror stats del pokemon
            Column(
                modifier = Modifier
                    .width(500.dp)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                statGeneric2(
                    name = "HP",
                    color = 0xFFc34749,
                    progressIndicator = pokemon.statHP / 255
                )
                statGeneric(
                    name = "ATK",
                    color = 0xFFf1a948,
                    progressIndicator = pokemon.statATK / 255
                )
                statGeneric(
                    name = "DEF",
                    color = 0xFF3f8ee1,
                    progressIndicator = pokemon.statDEF / 255
                )
                statGeneric(
                    name = "SPD",
                    color = 0xFF96aec3,
                    progressIndicator = pokemon.statSPD / 255
                )
                statGeneric2(
                    name = "SD",
                    color = 0xFF508a47,
                    progressIndicator = pokemon.statSD / 255
                )
                statGeneric2(
                    name = "SA",
                    color = 0xFFF7D02C,
                    progressIndicator = pokemon.statSA / 255
                )
            }
        }
    }
}
