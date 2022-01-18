package com.alex.rick.and.morty.app.presentation.character.list.navigate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alex.rick.and.morty.app.data.character.SingleCharacter
import com.alex.rick.and.morty.app.domain.usecase.RickAndMortyUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterNavigateListViewModel(
    private val rickAndMortyUseCase: RickAndMortyUseCase
) : ViewModel() {

    private val charactersInfoLv = MutableLiveData<List<SingleCharacter>>()
    fun charactersInfo(): MutableLiveData<List<SingleCharacter>> = charactersInfoLv

    private val setButtonsLv = MutableLiveData<Pair<Boolean, Boolean>>()
    fun setButtons(): MutableLiveData<Pair<Boolean, Boolean>> = setButtonsLv

    private val notifyErrorLv = MutableLiveData<Unit>()
    fun notifyError(): MutableLiveData<Unit> = notifyErrorLv

    fun getListCharacter(page: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val moviesInformation = withContext(Dispatchers.Default) {
                    rickAndMortyUseCase.getListCharacter(page.toString())
                }
                charactersInfoLv.value = moviesInformation
                setButtonsController(page)
            } catch (e: Exception) {
                notifyErrorLv.postValue(Unit)
            }

        }
    }

    private fun setButtonsController(page: Int) {
        when {
            page < 2 -> {
                setButtonsLv.postValue(Pair(first = false, second = true))
            }
            page > 41 -> {
                setButtonsLv.postValue(Pair(first = true, second = false))
            }
            else -> {
                setButtonsLv.postValue(Pair(first = true, second = true))
            }
        }
    }

}