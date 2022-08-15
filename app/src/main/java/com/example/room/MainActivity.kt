package com.example.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.room.local.MainAdd
import com.example.room.local.MainDao
import com.example.room.local.MainDatabase
import com.example.room.ui.theme.RoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val viewModel by viewModels<MainViewModel>()
                    val contacts:List<MainAdd> by viewModel.contacts
                    var name by remember{ mutableStateOf("")}
                    var phone by remember{ mutableStateOf("")}
                    var age by remember{ mutableStateOf("")}
                    var phoneState by remember{ mutableStateOf(0)}

                    LaunchedEffect(key1 = true ){
                        val contactDatabase = MainDatabase.getInstance(applicationContext)
                        val dao:MainDao = contactDatabase.getDao()
                        viewModel.dao = dao
                        viewModel.getAllContact()
                    }
                    LazyColumn(){
                        item(){
                            TextField(value = name, onValueChange ={name = it} )
                            TextField(value = phone, onValueChange = {phone = it})
                            TextField(value = age, onValueChange ={age = it} )
                            Button(onClick={
                                val id = 0
                                val main = MainAdd(
                                    id,
                                    name,
                                    phone.toInt(),
                                    age.toInt()
                                )
                                viewModel.addContact(main)
                            }){
                                Text("Ok")
                            }
                        }
                        items(contacts){contact ->
                            Card(modifier=Modifier.border(1.dp, Color.Black)){
                                Column(modifier=Modifier.padding(start = 10.dp)){
                                    Text("Name"+name)
                                    Text("Phone"+phone)
                                    Text("Age:"+age)
                                }
                            }
                            Spacer(modifier=Modifier.fillMaxWidth().padding(vertical = 10.dp))
                        }
                    }
                }
            }
        }
    }
}