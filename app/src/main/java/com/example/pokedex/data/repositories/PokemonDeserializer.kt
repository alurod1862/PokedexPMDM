package com.example.pokedex.data.repositories

import com.example.pokedex.domain.models.Pokemon
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.lang.reflect.Type
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonDeserializer : JsonDeserializer<Pokemon> {
    @Singleton
    override fun deserialize(json: JsonElement,typeOf:Type,context: JsonDeserializationContext): Pokemon {
        json as JsonObject


        val name = json.get("name").asString

        val height = json.get("height").asFloat

        val weight = json.get("weight").asFloat

        val id = json.get("id").asInt

        val sprite = json.get("sprites").asJsonObject
        val other = sprite.get("other").asJsonObject
        val officialArtwork = other.get("official-artwork").asJsonObject
        val imagen = officialArtwork.get("front_default").asString

        var statHP: Float=0.0f
        var statATK: Float=0.0f
        var statDEF: Float=0.0f
        var statSPD: Float=0.0f
        var statSD: Float=0.0f
        var statSA: Float=0.0f

        val stats = json.get("stats").asJsonArray
        stats.forEach{
            val actualStat = it.asJsonObject.get("stat")
            val statName = actualStat.asJsonObject.get("name").asString
            val baseStat = it.asJsonObject.get("base_stat").asFloat

            when (statName) {
                "hp" -> statHP = baseStat
                "attack" -> statATK = baseStat
                "defense" -> statDEF = baseStat
                "speed" -> statSPD = baseStat
                "special-defense" -> statSD = baseStat
                "special-attack" -> statSA = baseStat
            }
        }


        var type1:String = ""
        var type2:String? = null

        val types =  json.get("types").asJsonArray
        types.forEach{
            val actualType = it.asJsonObject.get("type")
            val typeName = actualType.asJsonObject.get("name").asString
            val slot = it.asJsonObject.get("slot").asInt

            when(slot){
                1 -> type1 = typeName
                2 -> type2 = typeName
            }

        }

        return Pokemon(name, height = height, weight = weight,id = id, imagen = imagen, type1 = type1, type2 = type2, statATK = statATK, statDEF = statDEF, statHP = statHP, statSD = statSD,statSA = statSA, statSPD = statSPD)
    }


}
