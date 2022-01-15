package com.alex.rick.and.morty.app.di

import com.alex.rick.and.morty.app.BuildConfig
import com.alex.rick.and.morty.app.data.api.RickAndMortyRemoteSource
import com.alex.rick.and.morty.app.data.api.ServiceFactory
import com.alex.rick.and.morty.app.data.character.RickAnMortyRepositoryImpl
import com.alex.rick.and.morty.app.domain.repository.RickAnMortyRepository
import com.alex.rick.and.morty.app.domain.usecase.RickAndMortyUseCase
import com.alex.rick.and.morty.app.domain.usecase.RickAndMortyUseCaseImpl
import com.alex.rick.and.morty.app.presentation.character.list.random.RandomCharacterListViewModel
import com.alex.rick.and.morty.app.presentation.details.DetailsCharacterViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val KOIN_RETROFIT = "retrofit"
const val KOIN_OKHTTP = "okhttp"

val mainModule = module {

    viewModel {
        DetailsCharacterViewModel(get())
    }

    viewModel {
        RandomCharacterListViewModel(get())
    }

    single<RickAndMortyUseCase> {
        RickAndMortyUseCaseImpl(get())
    }

    single<RickAnMortyRepository> {
        RickAnMortyRepositoryImpl(get())
    }

    single {
        Gson()
    }

    single {
        GsonConverterFactory.create(get<Gson>())
    }

    single {
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
        }
    }

    single(named(KOIN_OKHTTP)) {
        OkHttpClient().newBuilder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single(named(KOIN_RETROFIT)) {
        Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(get<GsonConverterFactory>())
            .client(get(named(KOIN_OKHTTP)))
            .build()
    }

    single {
        ServiceFactory.createService(
            get(named(KOIN_RETROFIT)),
            RickAndMortyRemoteSource::class.java
        )
    }
}