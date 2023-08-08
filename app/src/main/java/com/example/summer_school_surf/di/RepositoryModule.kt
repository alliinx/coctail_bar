
package com.example.summer_school_surf.di

import com.example.summer_school_surf.data.localdatasource.ICocktailDataSource
import com.example.summer_school_surf.data.repository.CocktailRepository
import com.example.summer_school_surf.domain.repository.ICocktailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCocktailRepository(cocktailLocalDataSource: ICocktailDataSource): ICocktailRepository =
        CocktailRepository(cocktailLocalDataSource)

}
