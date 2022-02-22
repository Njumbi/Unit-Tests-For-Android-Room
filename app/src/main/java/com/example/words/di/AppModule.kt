package com.example.words.di

import android.content.Context
import androidx.room.Room
import com.example.words.data.AppDatabase
import com.example.words.data.WordsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun appDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context,AppDatabase::class.java,"ourDatabase")
            .fallbackToDestructiveMigration()
            .build()

    }

   @Provides
   @Singleton
   fun providesWordDao( db: AppDatabase) : WordsDao{
       return db.wordDao()
   }



}