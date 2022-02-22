package com.example.words.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 data class Word (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="name")val name: String?,

)