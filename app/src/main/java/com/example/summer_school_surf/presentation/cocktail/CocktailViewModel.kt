package com.example.summer_school_surf.presentation.cocktail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.summer_school_surf.domain.model.Cocktail
import com.example.summer_school_surf.domain.usecase.DeleteCocktailUseCase
import com.example.summer_school_surf.domain.usecase.GetCocktailsUseCase
import com.example.summer_school_surf.domain.usecase.InsertCocktailUseCase
import com.example.summer_school_surf.domain.usecase.UpdateCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val insertCocktail: InsertCocktailUseCase,
    private val updateCocktail: UpdateCocktailUseCase,
    private val deleteCocktail: DeleteCocktailUseCase,
    getCocktails: GetCocktailsUseCase
):ViewModel(){

    val cocktails: LiveData<List<Cocktail?>> = getCocktails().asLiveData()

    fun insertCocktail(name:String, description:String, ingredients:List<String>, recipe:String)=
        liveData {
            emit(insertCocktail.invoke(name,description,ingredients,recipe))
        }

    fun deleteCocktail(id:Int)=viewModelScope.launch {
        deleteCocktail.invoke(id)
    }

    fun updateCocktail(cocktail: Cocktail)=viewModelScope.launch {
        updateCocktail.invoke(cocktail)
    }
}
