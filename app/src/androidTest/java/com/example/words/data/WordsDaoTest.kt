package com.example.words.data

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.*


@RunWith(AndroidJUnit4::class)
@SmallTest
class WordsDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var wordsDao: WordsDao

    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        wordsDao = database.wordDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun insertWord_returnsTrue() = runBlocking {
        val name = Word(id = 1, "Mary")
        wordsDao.insertWord(name)


        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            wordsDao.getAllWords().collect {
                assertThat(it).contains(name)
                latch.countDown()

            }
        }
        latch.await()
        job.cancelAndJoin()
    }

    @Test
    fun updateWord_returnsTrue() = runBlocking {
        //insert word
        val name = Word(id = 1, "Mary")
        wordsDao.insertWord(name)

        // create updated word
        val updatedWord = Word(id = 1, "John")

        // update
        wordsDao.updateWord(updatedWord)

        // get word and assert if it equals to updated word
        val result = wordsDao.getOneWord(updatedWord.id)

        assertThat(result.name).isEqualTo(updatedWord.name);

    }


    @Test
    fun delete_returnsTrue() = runBlocking {
        val name = Word(id = 1, "Mary")
        val secondName = Word(id = 2, "John")

        wordsDao.insertWord(name)
        wordsDao.insertWord(secondName)

        wordsDao.delete()

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            wordsDao.getAllWords().collect {
                assertThat(it).doesNotContain(name)
                latch.countDown()
            }
        }
        latch.await()
        job.cancelAndJoin()


    }

}