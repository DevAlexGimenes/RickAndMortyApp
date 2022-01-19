package com.alex.rick.and.morty.app.presentation.character.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.rick.and.morty.app.R
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.character_item_list.view.*

class CharacterInfoAdapter(
    private var characters: List<SingleCharacter>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CharacterInfoAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindCharacter(character: SingleCharacter) {
            Glide.with(itemView).load(character.image).into(itemView.image_character)
            itemView.txtNameList.text = character.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.character_item_list, parent, false)
        )
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bindCharacter(character)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(character)
        }
    }

    fun updateList(newList: List<SingleCharacter>) {
        characters = newList
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClicked(character: SingleCharacter)
    }
}