package com.example.summer_school_surf.domain.usecase

import com.example.summer_school_surf.domain.repository.ICocktailRepository

class DeleteCocktailUseCase (private val cocktailRepository:ICocktailRepository) {

    suspend operator fun invoke(taskId: Int) =
        cocktailRepository.deleteCocktail(taskId)
}