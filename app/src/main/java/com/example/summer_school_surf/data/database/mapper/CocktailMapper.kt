package com.example.summer_school_surf.data.database.mapper

import com.example.summer_school_surf.data.database.entity.CocktailEntity
import com.example.summer_school_surf.domain.model.Cocktail

object CocktailMapper {

//    fun CocktailEntity?.toDomain(): Cocktail? = this?.let {
//        Cocktail(
//            id = it.id,
//            name = it.name,
//            description = it.description,
//            ingredients = it.ingredients,
//            recipe = it.recipe
//        )
//    }

    fun CocktailEntity?.toDomain(): Cocktail? = this?.let {
        Cocktail(
            id = it.id,
            name = it.name,
            description = it.description,
            ingredients = it.ingredients,
            recipe = it.recipe
        )
    }


    fun Cocktail?.toEntity(): CocktailEntity? = this?.let {
        CocktailEntity(
            id = it.id,
            name = it.name,
            description = it.description,
            ingredients = it.ingredients,
            recipe = it.recipe
        )
    }
}