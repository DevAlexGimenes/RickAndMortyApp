package com.alex.rick.and.morty.app.presentation.details

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alex.rick.and.morty.app.R
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.presentation.StatusCharacter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details_character.*
import kotlinx.android.synthetic.main.notify_error_message.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsCharacterFragment : Fragment(R.layout.fragment_details_character) {

    private val viewModel: DetailsCharacterViewModel by viewModel()

    private val args: DetailsCharacterFragmentArgs by navArgs()

    override fun onResume() {
        super.onResume()
        prepareObservers()
    }

    private fun prepareObservers() {
        val view = View.inflate(context, R.layout.notify_loading_message, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        dialog.setCanceledOnTouchOutside(false)

        args.let {
            viewModel.getSingleCharacter(it.id)
        }

        viewModel
            .statusCharacter()
            .observe(viewLifecycleOwner, { status ->
                setStatusCharacter(status)
            })

        viewModel
            .notifySuccess()
            .observe(viewLifecycleOwner, {
                dialog.dismiss()
            })

        viewModel
            .singleCharacter()
            .observe(viewLifecycleOwner, { character ->
                setComponentsInformation(character)
            })

        viewModel
            .notifyError()
            .observe(viewLifecycleOwner, {
                dialog.dismiss()
                initNotifyError()
            })
    }

    private fun setComponentsInformation(character: SingleCharacter?) {
        txtName.text = character?.name
        Glide.with(profile_image).load(character?.image).into(profile_image)
        txtInfoSpecie.text = character?.species
        txtInfoGender.text = character?.gender
        txtInfoFirstSeeIn.text = character?.origin?.name
        txtInfoLastKnownLocation.text = character?.location?.name
    }

    @SuppressLint("ResourceAsColor")
    private fun setStatusCharacter(statusCharacter: StatusCharacter) {
        txtInfoStatus.text = getString(statusCharacter.status)
        txtInfoStatus.setTextColor(statusCharacter.textColor)
        imgStatus.setImageResource(statusCharacter.iconImg)
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
}

