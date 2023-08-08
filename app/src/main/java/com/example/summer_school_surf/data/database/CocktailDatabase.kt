package com.example.summer_school_surf.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.summer_school_surf.data.database.dao.CocktailDao
import com.example.summer_school_surf.data.database.entity.CocktailEntity
import kotlinx.coroutines.CoroutineDispatcher

@Database(
    entities = [CocktailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CocktailDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao


    companion object {
        private var INSTANCE: CocktailDatabase? = null

        fun getInstance(
            context: Context,
        ): CocktailDatabase? {
            if (INSTANCE == null) {
                synchronized(CocktailDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        CocktailDatabase::class.java, "cocktail_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}