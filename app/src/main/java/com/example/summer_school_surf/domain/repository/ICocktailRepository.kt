package com.example.summer_school_surf.domain.repository

import com.example.summer_school_surf.domain.model.Cocktail
import kotlinx.coroutines.flow.Flow

interface ICocktailRepository {

    fun getCocktails(): Flow<List<Cocktail?>>

    suspend fun deleteCocktail(id: Int)

    suspend fun insert(cocktail: Cocktail): Long?

    suspend fun updateCocktail(cocktail: Cocktail)

}