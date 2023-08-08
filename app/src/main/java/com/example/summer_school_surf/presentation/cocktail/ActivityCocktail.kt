package com.example.summer_school_surf.presentation.cocktail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.summer_school_surf.R
import com.example.summer_school_surf.databinding.ActivityCocktailsBinding
import com.example.summer_school_surf.databinding.ActivityMainBinding
import com.example.summer_school_surf.domain.repository.ICocktailRepository
import com.example.summer_school_surf.presentation.adapter.CocktailAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class ActivityCocktail:AppCompatActivity() {

    private lateinit var binding: ActivityCocktailsBinding

    private val cocktailAdapter = CocktailAdapter()

    private val cocktailViewModel: CocktailViewModel by viewModels()

    private lateinit var placeholderContainer: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCocktailsBinding.inflate(layoutInflater)

        placeholderContainer=binding.emptyPlaceholder.root

        binding.listCocktails.layoutManager = LinearLayoutManager(this)
        binding.listCocktails.adapter = cocktailAdapter


        cocktailViewModel.cocktails.observe(this, Observer {cocktail->
            cocktail?.let{
                cocktailAdapter.submitList(cocktail)
                updatePlaceholder()
            }
            //binding.noProjects.isVisible = it.isNullOrEmpty()

        })

//        mainViewModel.projectSelectedId.observe(viewLifecycleOwner) {
//            projectsAdapter.projectSelected = it
//            projectsAdapter.notifyDataSetChanged()
//        }

        binding.fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.container_add, AddCocktailFragment())
                .addToBackStack(null)
                .commit()
        }

        setContentView(binding.root)
    }

    private fun updatePlaceholder() {
        if (cocktailAdapter.itemCount == 0) {
            placeholderContainer.visibility = View.VISIBLE
        } else {
            placeholderContainer.visibility = View.GONE
        }
    }


}