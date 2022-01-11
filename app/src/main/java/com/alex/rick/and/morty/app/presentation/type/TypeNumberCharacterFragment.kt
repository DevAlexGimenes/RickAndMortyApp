package com.alex.rick.and.morty.app.presentation.type

import android.graphics.Color.parseColor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alex.rick.and.morty.app.R
import com.alex.rick.and.morty.app.databinding.TypeNumberCharacterFragmentBinding
import kotlinx.android.synthetic.main.navigation_bar_layout.*
import kotlinx.android.synthetic.main.type_number_character_fragment.*

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
        binding.btHome.setOnClickListener {
            if (binding.editTextInput.text.toString().isEmpty()) {
                binding.txtInfo.visibility = View.VISIBLE
                binding.iconImg.visibility = View.VISIBLE
            } else {
                binding.txtInfo.visibility = View.GONE
                binding.iconImg.visibility = View.GONE
            }
        }
    }
}