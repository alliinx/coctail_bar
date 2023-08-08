package com.example.summer_school_surf.presentation.adapter

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.summer_school_surf.databinding.CocktailItemBinding
import com.example.summer_school_surf.domain.model.Cocktail
import com.google.android.material.card.MaterialCardView

class CocktailAdapter: ListAdapter<Cocktail,CocktailAdapter.ViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            CocktailItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    inner class ViewHolder(private val binding: CocktailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cocktail: Cocktail) {
            binding.cocktail = cocktail
            binding.cocktailCard.transitionName=cocktail.id.toString()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }




    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Cocktail>() {

            override fun areItemsTheSame(oldCocktail: Cocktail, newCocktail: Cocktail) =
                oldCocktail.id == newCocktail.id

            override fun areContentsTheSame(oldCocktail: Cocktail, newCocktail: Cocktail) =
                oldCocktail == newCocktail
        }
    }
}