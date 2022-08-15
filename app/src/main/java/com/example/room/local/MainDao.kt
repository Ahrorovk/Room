package com.example.room.local

import androidx.room.*

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(mains:MainAdd)

    @Query("SELECT * FROM MainAdd_table")
    fun getAllMains():List<MainAdd>

    @Delete
    fun deleteMain(mains:MainAdd)
}