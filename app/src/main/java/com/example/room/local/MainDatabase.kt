package com.example.room.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [MainAdd::class], version = 1)
abstract class MainDatabase: RoomDatabase() {
    abstract fun getDao():MainDao
    companion object{
        var INSTANCE:MainDatabase? = null
        fun getInstance(context: Context):MainDatabase{
            synchronized(this){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MainDatabase::class.java,
                        "main_database"
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }
}