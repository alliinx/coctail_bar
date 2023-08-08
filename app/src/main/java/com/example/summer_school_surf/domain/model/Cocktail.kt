package com.example.summer_school_surf.domain.model

data class Cocktail (
    val id:Int=0,
    val name:String,
    val description:String?,
    val ingredients:List<String>,
    val recipe:String?
)