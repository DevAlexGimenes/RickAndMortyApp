package com.alex.rick.and.morty.app.domain

import com.alex.rick.and.morty.app.data.character.SingleCharacter
import kotlinx.coroutines.delay

class RickAndMortyUseCaseImpl(
    private val rickAnMortyRepository: RickAnMortyRepository
): RickAndMortyUseCase {
    override suspend fun getSingleCharacter(id: String) : SingleCharacter{
        return rickAnMortyRepository.getSingleCharacter(id)
    }
}