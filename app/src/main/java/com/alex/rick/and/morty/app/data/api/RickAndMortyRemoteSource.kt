package com.alex.rick.and.morty.app.data.api

import com.alex.rick.and.morty.app.data.character.SingleCharacter
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyRemoteSource {

    @GET("character/{id}")
    suspend fun getSingleCharacter(
        @Path("id")id: String
    ) : SingleCharacter
}