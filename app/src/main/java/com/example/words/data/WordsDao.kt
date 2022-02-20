package com.example.words.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {

    @Query("SELECT * FROM `word`")
    fun getAllWords(): Flow<List<Word>>

    @Query("DELETE  FROM `word`")
    suspend fun nuke()

    @Insert
   suspend fun insertWord(word: Word)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWord( word: Word)

}