package com.example.summer_school_surf.domain.usecase

import com.example.summer_school_surf.domain.model.Cocktail
import com.example.summer_school_surf.domain.repository.ICocktailRepository

class InsertCocktailUseCase (private val cocktailRepository: ICocktailRepository) {

    suspend operator fun invoke(
        name: String,
        description: String,
        ingredients: List<String>,
        recipe: String
    ): Long? =
        cocktailRepository.insert(
            Cocktail(
                name = name,
                description = description,
                ingredients = ingredients,
                recipe = recipe
            )
        )
}