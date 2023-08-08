package com.example.summer_school_surf.domain.usecase

import com.example.summer_school_surf.domain.model.Cocktail
import com.example.summer_school_surf.domain.repository.ICocktailRepository

class UpdateCocktailUseCase (private val cocktailRepository: ICocktailRepository){

    suspend operator fun invoke(cocktail: Cocktail) = cocktailRepository.updateCocktail(cocktail)
}