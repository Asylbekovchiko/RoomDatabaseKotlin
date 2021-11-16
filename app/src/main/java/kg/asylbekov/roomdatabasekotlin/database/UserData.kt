package kg.asylbekov.roomdatabasekotlin.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user_data")

@Parcelize
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int,
    val number: Int = 0,
    val address : String?,
    val children : String?,
    val a: String?
): Parcelable
