package com.example.pokedex.domain.models

import androidx.compose.ui.graphics.Color
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

enum class PokemonType (val colorInt: Long) {
    @Singleton
    NORMAL(0xFFA8A77A),
    FIRE(0xFFEE8130),
    WATER(0xFF6390F0),
    ELECTRIC(0xFFF7D02C),
    GRASS(0xFF7AC74C),
    ICE(0xFF96D9D6),
    FIGHTING(0xFFC22E28),
    POISON(0xFFA33EA1),
    GROUND(0xFFE2BF65),
    FLYING(0xFFA98FF3),
    PSYCHIC(0xFFF95587),
    BUG(0xFFA6B91A),
    ROCK(0xFFB6A136),
    GHOST(0xFF735797),
    DRAGON(0xFF6F35FC),
    DARK(0xFF705746),
    STEEL(0xFFB7B7CE),
    FAIRY(0xFFD685AD);

    val color: Color
        get() = Color(colorInt)
}
