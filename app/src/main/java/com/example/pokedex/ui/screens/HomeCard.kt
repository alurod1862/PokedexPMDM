package com.example.pokedex.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedex.data.api.RetrofitClient
import com.example.pokedex.ui.viewmodels.PokedexViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeCard(navComposable: NavController){

    var pokeName:String = ""

    LaunchedEffect(key1 = Unit) {
        val pokemon = RetrofitClient.pokemonApiService.getPokemonInfo("pikachu")
        pokeName = pokemon.name
    }


    val items2 = listOf(
        "pokememon 2",
        "pokememon 3",
        "pokememon 4",
        "pokememon 5"
    )
//items2.get(index)
    Column {

        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)){
            items(items2.size) { index ->
                CardPokemon(pokeName)
            }
        }
    }



}

@Composable
fun CardPokemon(pokemonName :String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.size(width = 140.dp, height = 100.dp)
    ) {
        Text(
            text = "$pokemonName",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}