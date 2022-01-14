package com.alex.rick.and.morty.app.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.domain.usecase.RickAndMortyUseCase
import com.alex.rick.and.morty.app.presentation.StatusCharacter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsCharacterViewModel(
    private val rickAndMortyUseCase: RickAndMortyUseCase
) : ViewModel() {

    private val notifyErrorLv = MutableLiveData<Unit>()
    fun notifyError(): MutableLiveData<Unit> = notifyErrorLv

    private val notifySuccessLv = MutableLiveData<Unit>()
    fun notifySuccess(): MutableLiveData<Unit> = notifySuccessLv

    private val statusCharacterLv = MutableLiveData<StatusCharacter>()
    fun statusCharacter(): MutableLiveData<StatusCharacter> = statusCharacterLv

    private val singleCharacterLv = MutableLiveData<SingleCharacter?>()
    fun singleCharacter(): MutableLiveData<SingleCharacter?> = singleCharacterLv

    fun getSingleCharacter(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val moviesInformation = withContext(Dispatchers.Default) {
                    rickAndMortyUseCase.getSingleCharacter(id)
                }
                singleCharacterLv.value = moviesInformation
                setStatusCharacterConfig()
            } catch (e: Exception) {
                notifyErrorLv.postValue(Unit)
            }

            if (singleCharacterLv.value != null) {
                notifySuccessLv.postValue(Unit)
            }
        }
    }

    private fun setStatusCharacterConfig() {
        when (singleCharacterLv.value?.status) {
            "Alive" -> {
                statusCharacterLv.postValue(StatusCharacter.STATUS_ALIVE)
            }
            "Dead" -> {
                statusCharacterLv.postValue(StatusCharacter.STATUS_DEAD)
            }
            else -> {
                statusCharacterLv.postValue(StatusCharacter.STATUS_UNKNOWN)
            }
        }
    }
}