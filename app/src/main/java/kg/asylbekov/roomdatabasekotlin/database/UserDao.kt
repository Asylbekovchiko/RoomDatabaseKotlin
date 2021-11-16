package kg.asylbekov.roomdatabasekotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user_data ORDER BY id ")
    fun getAllUsers(): LiveData<List<UserData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewUser(user: UserData)

    @Update
    suspend fun updateUser(user: UserData)

    @Delete
    suspend fun deleteuser(user: UserData)
}