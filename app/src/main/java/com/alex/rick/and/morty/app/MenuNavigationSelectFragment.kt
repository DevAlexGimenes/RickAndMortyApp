package com.alex.rick.and.morty.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_menu_navigation_select.*

class MenuNavigationSelectFragment : Fragment(R.layout.fragment_menu_navigation_select) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigation()
    }

    private fun setNavigation() {
        btnRandomCharacter.setOnClickListener {
            findNavController().navigate(R.id.action_menuNavigationSelectFragment_to_randomCharacterFragment)
        }

        btnTypeNumber.setOnClickListener {
            findNavController().navigate(R.id.action_menuNavigationSelectFragment_to_typeNumberCharacterFragment)
        }

        btnMenuListCharacters.setOnClickListener {
            findNavController().navigate(R.id.action_menuNavigationSelectFragment_to_menuListOfTheCharacterFragment)
        }
    }
}