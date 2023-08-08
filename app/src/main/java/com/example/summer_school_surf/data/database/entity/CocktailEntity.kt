package com.example.summer_school_surf.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cocktail")
data class CocktailEntity (
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    val name:String,
    val description:String?,
    val ingredients:List<String>,
    val recipe:String?
    )