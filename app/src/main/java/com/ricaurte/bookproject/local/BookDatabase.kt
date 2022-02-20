package com.ricaurte.bookproject.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase:RoomDatabase() {

    abstract fun BookDao(): BookDao

}
