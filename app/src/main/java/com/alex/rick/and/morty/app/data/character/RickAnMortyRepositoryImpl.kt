package com.alex.rick.and.morty.app.data.character

import com.alex.rick.and.morty.app.data.api.RickAndMortyRemoteSource
import com.alex.rick.and.morty.app.domain.repository.RickAnMortyRepository
import kotlinx.coroutines.delay

class RickAnMortyRepositoryImpl(
    private val rickAndMortyRemoteSource: RickAndMortyRemoteSource
) : RickAnMortyRepository {

    override suspend fun getSingleCharacter(id: String): SingleCharacter {
        delay(2000)
        return rickAndMortyRemoteSource.getSingleCharacter(id)
    }
}