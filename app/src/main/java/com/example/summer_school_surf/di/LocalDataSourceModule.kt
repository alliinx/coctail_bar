
package com.example.summer_school_surf.di

import com.example.summer_school_surf.data.database.dao.CocktailDao
import com.example.summer_school_surf.data.localdatasource.CocktailLocalDataSource
import com.example.summer_school_surf.data.localdatasource.ICocktailDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideCocktailLocalDataSource(cocktailDao:CocktailDao): ICocktailDataSource =
        CocktailLocalDataSource(cocktailDao)
}
