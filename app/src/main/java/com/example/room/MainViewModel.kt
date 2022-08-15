package com.example.room

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.local.MainAdd
import com.example.room.local.MainDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel:ViewModel() {
    val contacts = mutableStateOf<List<MainAdd>>(listOf())
    lateinit var  dao:MainDao

    fun getAllContact(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                contacts.value = dao.getAllMains()
            }
        }
    }
    fun addContact(contact: MainAdd){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                dao.add(contact)
                getAllContact()
            }
        }
    }
}