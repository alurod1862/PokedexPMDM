package com.example.pokedex.logic

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type
import java.nio.file.Files.size


class PokemonDeserializer : JsonDeserializer<Pokemon> {

    override fun deserialize(json: JsonElement,typeOf:Type,context: JsonDeserializationContext):Pokemon {
        json as JsonObject


        val name = json.get("name").asString

        val height = json.get("height").asFloat

        val id = json.get("id").asInt

        val sprite = json.get("sprite").asJsonObject
        val other = sprite.get("other").asJsonObject
        val officialArtwork = other.get("official-artwork").asJsonObject
        val imagen = officialArtwork.get("front-default").asString

        var statHP: Float=0.0f
        var statATK: Float=0.0f
        var statDEF: Float=0.0f
        var statSPD: Float=0.0f
        var statEXP: Float=0.0f

        val statsA = json.get("stats").asJsonArray
        statsA.forEach{
            val actualStat = it.asJsonObject.get("stat")

            when (actualStat.asJsonObject.get("name").asString){
                "hp" -> statHP = it.asJsonObject.get("base_stat").asFloat
            }


        }

        return Pokemon(name, height = height,id = id, imagen = imagen)


    }


}
