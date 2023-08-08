package com.example.summer_school_surf.domain.usecase

import com.example.summer_school_surf.domain.model.Cocktail
import com.example.summer_school_surf.domain.repository.ICocktailRepository
import kotlinx.coroutines.flow.Flow

class GetCocktailsUseCase (private val cocktailRepository: ICocktailRepository) {

    operator fun invoke(): Flow<List<Cocktail?>> =
        cocktailRepository.getCocktails()
}