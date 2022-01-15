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
    private var movies: List<SingleCharacter>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<CharacterInfoAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindMovie(character: SingleCharacter) {
            Glide.with(itemView).load(character.image).into(itemView.image_character)
            itemView.txtNameList.text = character.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.character_item_list, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val character = movies[position]
        holder.bindMovie(character)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(character)
        }
    }

    fun updateList(newList: List<SingleCharacter>) {
        movies = newList
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClicked(movie: SingleCharacter)
    }
}