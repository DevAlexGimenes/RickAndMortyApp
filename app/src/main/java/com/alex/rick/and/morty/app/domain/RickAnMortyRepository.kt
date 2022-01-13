package com.alex.rick.and.morty.app.domain

import com.alex.rick.and.morty.app.data.character.SingleCharacter

interface RickAnMortyRepository {

    suspend fun getSingleCharacter(id: String) : SingleCharacter
}