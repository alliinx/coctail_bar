package com.example.summer_school_surf.presentation.cocktail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.viewModels
import com.example.summer_school_surf.R
import com.example.summer_school_surf.databinding.AddCocktailFragmentBinding
import com.example.summer_school_surf.databinding.AddIngredientDialogBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Objects

@AndroidEntryPoint
class AddCocktailFragment: Fragment(){
    private var _binding: AddCocktailFragmentBinding?=null
    private val binding get() = _binding!!

    private val cocktailViewModel by viewModels<CocktailViewModel>()

    private val ingredients: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddCocktailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bindingIngredient: AddIngredientDialogBinding = AddIngredientDialogBinding.inflate(layoutInflater)

        binding.btnAddIngredient.setOnClickListener{
            val addIngredientDialog = AddIngredientDialog()
            val manager = childFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            addIngredientDialog.show(transaction, addIngredientDialog.TAG)
            ingredients.add(bindingIngredient.cocktailIngredientEditText.text.toString())
        }

        binding.buttonSave.setOnClickListener {
            createCocktail()
        }


    }

    private fun createCocktail() {
        if (validateCocktailName()) {
            insertTask()
        }
    }

    private fun validateCocktailName(): Boolean {
        //binding.cocktailNameEditText.clearError()
        return if (binding.cocktailNameEditText.text.isNullOrBlank()) {
            binding.cocktailNameEditText.error = getString(R.string.must_be_not_empty)
            false
        } else {
            true
        }
    }

//    fun EditText.clearError(){
//        error=null
//    }

    private fun insertTask() {
        val name = binding.cocktailNameEditText.text.toString()
        val description = binding.descriptionCocktailEnterField.text.toString()
        //val ingredients = binding.chipGroup
        val recipe = binding.recipeCocktailEnterField.text.toString()
        cocktailViewModel.insertCocktail(name, description, ingredients, recipe)
//            .observe(viewLifecycleOwner) {
//                activity?.hideSoftKeyboard()
//            }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}


