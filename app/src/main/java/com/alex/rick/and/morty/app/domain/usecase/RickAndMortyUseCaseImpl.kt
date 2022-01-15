package com.alex.rick.and.morty.app.domain.usecase

import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.domain.repository.RickAnMortyRepository

class RickAndMortyUseCaseImpl(
    private val rickAnMortyRepository: RickAnMortyRepository
): RickAndMortyUseCase {
    override suspend fun getSingleCharacter(id: String) : SingleCharacter{
        return rickAnMortyRepository.getSingleCharacter(id)
    }

    override suspend fun getListCharacter(page: String): List<SingleCharacter> {
        return rickAnMortyRepository.getListCharacter(page)
    }
}