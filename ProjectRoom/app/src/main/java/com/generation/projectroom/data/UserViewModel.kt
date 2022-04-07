package com.generation.projectroom.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.projectroom.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (context: Context?): ViewModel(){
    val lerDados: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDAO = UserDataBase.getDatabase(context!!).userDao()
        repository = UserRepository(userDAO)
        lerDados = repository.lerDados
    }

    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addUser(user)

        }
    }

}