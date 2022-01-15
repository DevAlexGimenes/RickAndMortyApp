package com.alex.rick.and.morty.app.domain.repository

import com.alex.rick.and.morty.app.data.character.ListCharacterResponse
import com.alex.rick.and.morty.app.data.character.SingleCharacter

interface RickAnMortyRepository {

    suspend fun getSingleCharacter(id: String) : SingleCharacter

    suspend fun getListCharacter(page: String) : List<SingleCharacter>
}