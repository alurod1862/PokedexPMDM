package com.example.pokedex.data.repositories

import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.models.PokemonResult
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.lang.reflect.Type

@Module
@InstallIn(SingletonComponent::class)
class PokemonDeserializerList : JsonDeserializer<PokemonList> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): PokemonList {
        val jsonObject = json?.asJsonObject
        val results = jsonObject?.get("results")?.asJsonArray
        val pokemonList = mutableListOf<PokemonResult>()
        results?.forEach {
            val pokemonResult = PokemonResult(
                name = it.asJsonObject.get("name").asString,
                url = it.asJsonObject.get("url").asString
            )
            pokemonList.add(pokemonResult)
        }
        return PokemonList(pokemonList)

    }
}