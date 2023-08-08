package com.example.summer_school_surf.data.repository

import com.example.summer_school_surf.data.localdatasource.ICocktailDataSource
import com.example.summer_school_surf.domain.model.Cocktail
import com.example.summer_school_surf.domain.repository.ICocktailRepository
import kotlinx.coroutines.flow.Flow

class CocktailRepository(
    private val cocktailLocalDataSource: ICocktailDataSource
):ICocktailRepository{

    override fun getCocktails(): Flow<List<Cocktail?>> = cocktailLocalDataSource.getCocktails()

    override suspend fun deleteCocktail(id: Int) {
        cocktailLocalDataSource.deleteCocktail(id)
    }

    override suspend fun insert(cocktail: Cocktail): Long? = cocktailLocalDataSource.insert(cocktail)


    override suspend fun updateCocktail(cocktail: Cocktail) {
        cocktailLocalDataSource.updateCocktail(cocktail)
    }
}