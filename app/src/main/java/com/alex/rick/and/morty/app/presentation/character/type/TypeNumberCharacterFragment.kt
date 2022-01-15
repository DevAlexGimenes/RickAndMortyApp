package com.alex.rick.and.morty.app.presentation.character.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.rick.and.morty.app.databinding.TypeNumberCharacterFragmentBinding

class TypeNumberCharacterFragment : Fragment() {

    private var _binding: TypeNumberCharacterFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TypeNumberCharacterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareContentView()
    }

    private fun prepareContentView() {

        binding.btnContinue.setOnClickListener {
            val value = binding.subTitle.text.toString()

            if (value.isEmpty() || value.toInt() < 1 || value.toInt() > 826) {
                binding.txtError.visibility = View.VISIBLE
                binding.iconError.visibility = View.VISIBLE
            } else {
                binding.txtError.visibility = View.GONE
                binding.iconError.visibility = View.GONE

                val action =
                    TypeNumberCharacterFragmentDirections
                        .actionTypeNumberCharacterFragmentToDetailsCharacterFragment(
                        id = binding.subTitle.text.toString()
                    )
                findNavController().navigate(action)
            }
        }
    }
}


