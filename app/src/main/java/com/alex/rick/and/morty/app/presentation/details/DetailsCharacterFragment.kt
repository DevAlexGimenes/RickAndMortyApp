package com.alex.rick.and.morty.app.presentation.details

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.alex.rick.and.morty.app.R
import kotlinx.android.synthetic.main.fragment_details_character.*
import kotlinx.android.synthetic.main.notify_error_message.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsCharacterFragment : Fragment() {

    private val viewModel: DetailsCharacterViewModel by viewModel()

    private val args: DetailsCharacterFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_character, container, false)
    }

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

        args.let {
            viewModel.getSingleCharacter(it.id)
        }

        viewModel
            .notifySuccess()
            .observe(viewLifecycleOwner, {
                dialog.dismiss()
            })

        viewModel
            .singleCharacter()
            .observe(viewLifecycleOwner, {
                txtTeste.text = it?.status
            })

        viewModel
            .notifyError()
            .observe(viewLifecycleOwner, {
                dialog.dismiss()
                initNotifyError()
            })
    }

    private fun initNotifyError() {
        val view = View.inflate(context, R.layout.notify_error_message, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        btn_back.setOnClickListener {
            dialog.dismiss()
        }
    }
}

