package com.example.pokedex.ui.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.pokedex.data.api.PokemonApiService
import com.example.pokedex.data.api.PokemonListApiService
import com.example.pokedex.data.api.RetroFitList
import com.example.pokedex.data.api.RetrofitClient
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.data.models.PokemonListResponse
import com.example.pokedex.ui.viewmodels.PokedexViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeCard(navComposable: NavController,pokedexViewModel: PokedexViewModel){

    Column {

        var pokemon:String=""

        var pokemonCount by remember { mutableStateOf(0) }

        LaunchedEffect(key1 = true) {
            RetroFitList.getPokemonListApiService().getPokemonList().enqueue(object : retrofit2.Callback<PokemonListResponse> {
                override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                    if (response.isSuccessful) {
                        pokemonCount = response.body()?.count ?: 0

                    }
                }
                override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                }
            })
            RetrofitClient.pokemonApiService.getPokemonInfo("")


        }


        Spacer(modifier = Modifier.size(80.dp))
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)){
            items(pokemonCount) { index -> CardPokemon(pokemon)
            }
        }
    }
}
@Composable
fun CardPokemon(pokemonName: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .padding(5.dp)
    ) {
        Text(
            text = "$pokemonName",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

