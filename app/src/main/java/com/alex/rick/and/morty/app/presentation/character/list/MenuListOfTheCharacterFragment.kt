package com.alex.rick.and.morty.app.presentation.character.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alex.rick.and.morty.app.databinding.MenuListOfTheCharacterFragmentBinding

class MenuListOfTheCharacterFragment : Fragment() {

    private var _binding: MenuListOfTheCharacterFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MenuListOfTheCharacterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareContentView()
    }

    private fun prepareContentView() {
        binding.btnRandomNumber.isEnabled = false

        binding.btnGifRandomCharacter.setOnClickListener {
            val randomNumber = (1..826).random()
            binding.showRandomNumber.text = randomNumber.toString()
            binding.btnRandomNumber.isEnabled = true
        }
    }

}