package com.alex.rick.and.morty.app.data.character

import com.alex.rick.and.morty.app.data.api.RickAndMortyRemoteSource
import com.alex.rick.and.morty.app.domain.RickAnMortyRepository

class RickAnMortyRepositoryImpl(
    private val rickAndMortyRemoteSource: RickAndMortyRemoteSource
) : RickAnMortyRepository {

    override suspend fun getSingleCharacter(id: String): SingleCharacter {
        return rickAndMortyRemoteSource.getSingleCharacter(id)
    }
}