package com.alex.rick.and.morty.app.presentation.character.list.random

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.domain.usecase.RickAndMortyUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RandomCharacterListViewModel(
    private val rickAndMortyUseCase: RickAndMortyUseCase
) : ViewModel() {

    private val charactersInfoLv = MutableLiveData<List<SingleCharacter>>()
    fun charactersInfoLv(): MutableLiveData<List<SingleCharacter>> = charactersInfoLv

    private val notifyErrorLv = MutableLiveData<Unit>()
    fun notifyError(): MutableLiveData<Unit> = notifyErrorLv

    fun getListCharacter(page: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val characterInfo = withContext(Dispatchers.Default) {
                    rickAndMortyUseCase.getListCharacter(page)
                }
                charactersInfoLv.value = characterInfo
            } catch (e: Exception) {
                notifyErrorLv.postValue(Unit)
            }
        }
    }
}