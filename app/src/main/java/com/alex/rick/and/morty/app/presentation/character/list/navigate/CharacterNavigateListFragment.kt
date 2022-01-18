package com.alex.rick.and.morty.app.presentation.character.list.navigate

import android.app.AlertDialog
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alex.rick.and.morty.app.R
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.presentation.character.list.CharacterInfoAdapter
import kotlinx.android.synthetic.main.fragment_character_navigate_list.*
import kotlinx.android.synthetic.main.notify_error_message.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterNavigateListFragment : Fragment(R.layout.fragment_character_navigate_list),
    CharacterInfoAdapter.OnItemClickListener {

    private val viewModel: CharacterNavigateListViewModel by viewModel()

    private var pageNumber: Int = 1

    override fun onResume() {
        super.onResume()
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

        viewModel.setButtons().observe(viewLifecycleOwner, {
            btnNextArrow.isEnabled = it.second
            btnBackArrow.isEnabled = it.first
        })

        viewModel
            .notifyError()
            .observe(viewLifecycleOwner, {
                dialog.dismiss()
                initNotifyError()
            })

        btnBackArrow.setOnClickListener {
            onClickBackPage(characterAdapter)
            dialog.show()
        }

        btnNextArrow.setOnClickListener {
            onClickNextPage(characterAdapter)
            dialog.show()
        }

        RvItemListRandom.layoutManager = LinearLayoutManager(context)
        RvItemListRandom.setHasFixedSize(true)
        RvItemListRandom.adapter = characterAdapter

        showRandomNumberList.text = pageNumber.toString()

        viewModel.getListCharacter(pageNumber)
        viewModel.charactersInfo().observe(viewLifecycleOwner, Observer { character ->
            RvItemListRandom.scrollToPosition(0)
            characterAdapter.updateList(character)
            dialog.dismiss()
        })
    }

    private fun initNotifyError() {
        val view = View.inflate(context, R.layout.notify_error_message, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        view.btnBack.setOnClickListener {
            dialog.dismiss()
            findNavController().navigateUp()
        }
    }

    private fun onClickNextPage(characterInfoAdapter: CharacterInfoAdapter) {
        pageNumber++
        showRandomNumberList.text = pageNumber.toString()
        viewModel.getListCharacter(pageNumber)
        viewModel.charactersInfo().observe(viewLifecycleOwner, Observer { character ->
            characterInfoAdapter.updateList(character)
        })
    }

    private fun onClickBackPage(characterInfoAdapter: CharacterInfoAdapter) {
        pageNumber--
        showRandomNumberList.text = pageNumber.toString()
        viewModel.getListCharacter(pageNumber)
        viewModel.charactersInfo().observe(viewLifecycleOwner, Observer { character ->
            characterInfoAdapter.updateList(character)
        })
    }

    override fun onItemClicked(character: SingleCharacter) {
        val action = CharacterNavigateListFragmentDirections
            .actionCharacterNavigateListFragmentToDetailsCharacterFragment(
                id = character.id.toString()
            )
        findNavController().navigate(action)
    }
}