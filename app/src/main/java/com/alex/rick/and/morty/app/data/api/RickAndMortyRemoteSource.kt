package com.alex.rick.and.morty.app.data.api

import com.alex.rick.and.morty.app.data.character.ListCharacterResponse
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyRemoteSource {

    @GET("character/{id}")
    suspend fun getSingleCharacter(
        @Path("id") id: String
    ): SingleCharacter

    @GET("character/")
    suspend fun getListCharacter(
        @Query("page") page: String
    ): ListCharacterResponse

}