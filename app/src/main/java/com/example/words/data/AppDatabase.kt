package com.example.words.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ Word::class],version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): WordsDao
}