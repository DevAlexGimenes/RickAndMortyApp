package com.alex.rick.and.morty.app.presentation.character.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.rick.and.morty.app.databinding.RandomCharacterFragmentBinding
import com.alex.rick.and.morty.app.presentation.details.DetailsCharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomCharacterFragment : Fragment() {



    private var _binding: RandomCharacterFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RandomCharacterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareContentView()

    }

    private fun prepareContentView() {
        binding.btHome.isEnabled = false
        var randomNumber = 0

        binding.btnGifRandomCharacter.setOnClickListener {
            randomNumber = (1..826).random()
            binding.showRandomNumber.text = randomNumber.toString()
            binding.btHome.isEnabled = true
        }

        binding.btHome.setOnClickListener {
            val action = RandomCharacterFragmentDirections
                .actionRandomCharacterFragmentToDetailsCharacterFragment(
                    id = randomNumber.toString()
                )
            findNavController().navigate(action)
        }
    }
}
