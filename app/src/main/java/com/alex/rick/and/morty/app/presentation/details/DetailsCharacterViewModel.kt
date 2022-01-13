package com.alex.rick.and.morty.app.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.domain.RickAndMortyUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsCharacterViewModel(
    private val rickAndMortyUseCase: RickAndMortyUseCase
) : ViewModel() {

    private val notifyErrorLv = MutableLiveData<Unit>()
    fun notifyError() : MutableLiveData<Unit> = notifyErrorLv

    private val singleCharacterLv = MutableLiveData<SingleCharacter>()
    fun singleCharacter(): MutableLiveData<SingleCharacter> = singleCharacterLv

    fun getSingleCharacter(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val moviesInformation = withContext(Dispatchers.Default) {
                    rickAndMortyUseCase.getSingleCharacter(id)
                }
                singleCharacterLv.value = moviesInformation
            } catch (e: Exception) {
                println("ERROR: $e")
                notifyErrorLv.postValue(Unit)
            }

        }
    }
}