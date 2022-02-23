package com.example.words.repository

import com.example.words.data.Word
import com.example.words.data.WordsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class wordsRepository @Inject constructor(val wordsDao: WordsDao){

    suspend fun insertWord(word: Word){
        wordsDao.insertWord(word)
    }

    suspend fun deleteWord(){
        wordsDao.delete()
    }


    fun fetchAllWords() : Flow<List<Word>> {
        return wordsDao.getAllWords()
            .flowOn(Dispatchers.Default)
            .conflate()
    }



}