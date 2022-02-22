package com.example.words.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.words.data.Word
import com.example.words.repository.wordsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsViewModel@Inject  constructor(val wordsRepository: wordsRepository) : ViewModel(){

    val word: LiveData<List<Word>> = wordsRepository.fetchAllWords().asLiveData()


    fun insertWord(word: Word){
        viewModelScope.launch {
            wordsRepository.insertWord(word)
        }
    }




    fun deleteAllWords(){
        viewModelScope.launch {
            wordsRepository.deleteWord()
        }
    }

}