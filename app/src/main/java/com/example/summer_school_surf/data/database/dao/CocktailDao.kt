package com.example.summer_school_surf.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.summer_school_surf.data.database.entity.CocktailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktail ORDER BY id ASC")
    fun getCocktails(): Flow<List<CocktailEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCocktail(task: CocktailEntity): Long

    @Update
    suspend fun updateCocktails(task: CocktailEntity)

    @Query("DELETE FROM cocktail WHERE id = :id")
    suspend fun deleteCocktail(id: Int)
}