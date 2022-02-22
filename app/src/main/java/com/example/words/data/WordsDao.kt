package com.example.words.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {

    @Query("SELECT * FROM `word`")
    fun getAllWords(): Flow<List<Word>>

    @Query("SELECT * FROM `word` where id = :wordId")
    suspend fun getOneWord(wordId: Int): Word

    @Query("DELETE FROM word")
    suspend fun nuke()

    @Insert
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)


}