package com.example.summer_school_surf.di

import android.app.Application
import androidx.room.Room
import com.example.summer_school_surf.data.database.CocktailDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideCocktailDatabase(application: Application) =
        Room.databaseBuilder(application, CocktailDatabase::class.java, "CocktailDatabase.db")
            //.createFromAsset("database/AppDatabase.db")
            .build()

    @Provides
    fun provideCocktailDao(cocktailDatabase: CocktailDatabase) = cocktailDatabase.cocktailDao()
}
