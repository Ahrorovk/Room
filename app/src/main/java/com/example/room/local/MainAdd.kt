package com.example.room.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MainAdd_table")
data class MainAdd(
    @PrimaryKey(autoGenerate = true) val id:Int? = null,
    val name:String,
    val phone:Int,
    val age:Int
)