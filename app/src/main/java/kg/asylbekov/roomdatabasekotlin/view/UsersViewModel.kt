package kg.asylbekov.roomdatabasekotlin.view

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kg.asylbekov.roomdatabasekotlin.database.UserData
import kg.asylbekov.roomdatabasekotlin.database.UserDataBase
import kg.asylbekov.roomdatabasekotlin.repo.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(context: Application): AndroidViewModel(context) {

    val getAllUsers: LiveData<List<UserData>>
    private val repo: UserRepository

    init {
        val userDao = UserDataBase.getInstanceDataBase(context).userDao()
        repo = UserRepository(userDao)
        getAllUsers = repo.getAllUsers()
    }
    fun addUser(user: UserData){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addUser(user)

        }
    }
    fun deleteUser(user: UserData){
        viewModelScope.launch(Dispatchers.IO) {
            repo.delete(user)
        }
    }

    fun updateUser(user: UserData){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateUser(user)
        }
    }

}
