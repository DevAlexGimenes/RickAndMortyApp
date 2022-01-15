package com.alex.rick.and.morty.app.presentation.character.list.random

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alex.rick.and.morty.app.R
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.presentation.character.list.CharacterInfoAdapter
import kotlinx.android.synthetic.main.fragment_random_character_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomCharacterListFragment : Fragment(R.layout.fragment_random_character_list),
    CharacterInfoAdapter.OnItemClickListener {

    private val args: RandomCharacterListFragmentArgs by navArgs()

    private val viewModel: RandomCharacterListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareContent()
    }

    private fun prepareContent() {
        val view = View.inflate(context, R.layout.notify_loading_message, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)

        val characterAdapter = CharacterInfoAdapter(emptyList(), this)

        RvItemListRandom.layoutManager = LinearLayoutManager(context)
        RvItemListRandom.setHasFixedSize(true)
        RvItemListRandom.adapter = characterAdapter

        args.let { args ->
            showRandomNumberList.text = args.id
            viewModel.getListCharacter(args.id)
            viewModel.charactersInfoLv().observe(viewLifecycleOwner, Observer { character ->
                characterAdapter.updateList(character)
                dialog.dismiss()
            })
        }

    }

    override fun onItemClicked(character: SingleCharacter) {
        val action = RandomCharacterListFragmentDirections
            .actionRandomCharacterListFragmentToDetailsCharacterFragment(
                id = character.id.toString()
            )
        findNavController().navigate(action)

    }

}