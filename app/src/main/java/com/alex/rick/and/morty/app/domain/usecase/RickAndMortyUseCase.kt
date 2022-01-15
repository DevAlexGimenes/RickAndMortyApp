package com.alex.rick.and.morty.app.domain.usecase

import com.alex.rick.and.morty.app.data.character.SingleCharacter

interface RickAndMortyUseCase {

    suspend fun getSingleCharacter(id: String) : SingleCharacter

    suspend fun getListCharacter(page: String) : List<SingleCharacter>
}