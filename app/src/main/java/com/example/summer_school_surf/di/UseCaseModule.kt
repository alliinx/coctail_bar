
package com.example.summer_school_surf.di

import com.example.summer_school_surf.domain.repository.ICocktailRepository
import com.example.summer_school_surf.domain.usecase.DeleteCocktailUseCase
import com.example.summer_school_surf.domain.usecase.GetCocktailsUseCase
import com.example.summer_school_surf.domain.usecase.InsertCocktailUseCase
import com.example.summer_school_surf.domain.usecase.UpdateCocktailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetCocktailsUseCase(
        cocktailRepository: ICocktailRepository)
    = GetCocktailsUseCase(cocktailRepository)

    @Provides
    @ViewModelScoped
    fun provideInsertCocktailUseCase(
        cocktailRepository: ICocktailRepository
    ) = InsertCocktailUseCase(cocktailRepository)

    @Provides
    @ViewModelScoped
    fun provideDeleteCocktailUseCase(
        cocktailRepository: ICocktailRepository
    ) = DeleteCocktailUseCase(cocktailRepository)

    @Provides
    @ViewModelScoped
    fun provideUpdateCocktailUseCase(
        cocktailRepository: ICocktailRepository
    ) = UpdateCocktailUseCase(cocktailRepository)
}
