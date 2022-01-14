package com.alex.rick.and.morty.app.data.character

import com.alex.rick.and.morty.app.data.api.RickAndMortyRemoteSource
import com.alex.rick.and.morty.app.domain.RickAnMortyRepository
import kotlinx.coroutines.delay

class RickAnMortyRepositoryImpl(
    private val rickAndMortyRemoteSource: RickAndMortyRemoteSource
) : RickAnMortyRepository {

    override suspend fun getSingleCharacter(id: String): SingleCharacter {
        delay(5000)
        return rickAndMortyRemoteSource.getSingleCharacter(id)
    }
}