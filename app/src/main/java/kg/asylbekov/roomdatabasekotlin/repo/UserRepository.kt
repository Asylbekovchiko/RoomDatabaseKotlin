package kg.asylbekov.roomdatabasekotlin.repo

import androidx.lifecycle.LiveData
import kg.asylbekov.roomdatabasekotlin.database.UserDao
import kg.asylbekov.roomdatabasekotlin.database.UserData

class UserRepository(private val userDao: UserDao) {

    fun getAllUsers(): LiveData<List<UserData>> = userDao.getAllUsers()

    suspend fun addUser(user: UserData) {
        userDao.addNewUser(user)
    }
    suspend fun delete(user: UserData){
        userDao.deleteuser(user)
    }
    suspend fun updateUser(user: UserData){
        userDao.updateUser(user)
    }
}