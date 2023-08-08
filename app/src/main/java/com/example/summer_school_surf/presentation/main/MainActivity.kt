package com.example.summer_school_surf.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.summer_school_surf.databinding.ActivityMainBinding
import com.example.summer_school_surf.presentation.cocktail.ActivityCocktail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.fabMain.setOnClickListener {
            val intent= Intent(this, ActivityCocktail::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}