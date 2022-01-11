package com.alex.rick.and.morty.app

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.alex.rick.and.morty.app.databinding.ActivityMainBinding
import com.alex.rick.and.morty.app.presentation.list.MenuListOfTheCharacterFragment
import com.alex.rick.and.morty.app.presentation.random.RandomCharacterFragment
import com.alex.rick.and.morty.app.presentation.type.TypeNumberCharacterFragment
import kotlinx.android.synthetic.main.navigation_bar_layout.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()
    }

}