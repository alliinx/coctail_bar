package com.example.summer_school_surf.presentation.cocktail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.summer_school_surf.databinding.AddCocktailFragmentBinding
import com.example.summer_school_surf.databinding.AddIngredientDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddIngredientDialog: DialogFragment() {

    val TAG: String = AddIngredientDialog::class.java.simpleName

    private var _binding: AddIngredientDialogBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddIngredientDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

}