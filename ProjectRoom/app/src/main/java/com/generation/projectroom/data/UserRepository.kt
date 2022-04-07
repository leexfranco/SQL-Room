package com.generation.projectroom.data

import androidx.lifecycle.LiveData
import com.generation.projectroom.model.User

class UserRepository (private val userDAO: UserDAO){

    val lerDados: LiveData<List<User>> = userDAO.lerDados()

    fun addUser (user: User){
        userDAO.addUser(user)
    }

}