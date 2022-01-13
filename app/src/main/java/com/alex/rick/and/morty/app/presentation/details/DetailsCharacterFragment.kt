package com.alex.rick.and.morty.app.presentation.details

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.alex.rick.and.morty.app.R
import kotlinx.android.synthetic.main.fragment_details_character.*
import kotlinx.android.synthetic.main.notify_error_message.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.coroutineContext


class DetailsCharacterFragment : Fragment() {

    private val viewModel: DetailsCharacterViewModel by viewModel()

    private val args: DetailsCharacterFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareObservers()
    }

    private fun prepareObservers() {
        args.let {
            viewModel.getSingleCharacter(it.id)
        }

        viewModel
            .singleCharacter()
            .observe(viewLifecycleOwner, Observer {
                txtTeste.text = it.status
            })

        viewModel
            .notifyError()
            .observe(viewLifecycleOwner, Observer {
                Toast.makeText(context, "AAAAAAAAAAAAAAAA", Toast.LENGTH_SHORT).show()
                winDialogAlert()
            })
    }

    private fun winDialogAlert() {
        val view = View.inflate(context, R.layout.notify_error_message, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        view.btn_confirm.setOnClickListener {
            dialog.dismiss()
        }
    }
}

