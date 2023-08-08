package com.example.summer_school_surf.data.localdatasource

import com.example.summer_school_surf.data.database.dao.CocktailDao
import com.example.summer_school_surf.data.database.mapper.CocktailMapper.toDomain
import com.example.summer_school_surf.data.database.mapper.CocktailMapper.toEntity
import com.example.summer_school_surf.domain.model.Cocktail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CocktailLocalDataSource(private val cocktailDao: CocktailDao): ICocktailDataSource {

    override fun getCocktails(): Flow<List<Cocktail?>> = cocktailDao.getCocktails().map { list ->
        list.map {
            it.toDomain()
        } }

    override suspend fun deleteCocktail(id: Int) {
        cocktailDao.deleteCocktail(id)
    }

    override suspend fun insert(cocktail: Cocktail): Long? =
        cocktail.toEntity()?.let { cocktailDao.insertCocktail(it) }

    override suspend fun updateCocktail(cocktail: Cocktail) {
        cocktail.toEntity()?.let { cocktailDao.updateCocktails(it) }
    }
}