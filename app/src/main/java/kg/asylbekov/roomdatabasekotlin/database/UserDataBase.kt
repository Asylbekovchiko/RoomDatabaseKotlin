package kg.asylbekov.roomdatabasekotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [UserData::class], version = 7, exportSchema = false)

abstract class UserDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        var INSTANCE: UserDataBase? = null

        val MIGRATION_6_7 = object : Migration(6,7) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE 'user_data' ADD COLUMN 'a' 'TEXT'"
                    //"ALTER TABLE 'user_data' ADD COLUMN 'number' INTEGER NOT NULL DEFAULT 0" //
                )
            }
        }
        fun getInstanceDataBase(context: Context): UserDataBase{
            val temporaryInstance = INSTANCE
           synchronized(this){
               if(temporaryInstance != null){
                   return temporaryInstance
               }else{
                   val instance = Room.databaseBuilder(context.applicationContext, UserDataBase::class.java, "user_data")
                       .addMigrations(MIGRATION_6_7)
                       .build()
                    INSTANCE = instance
                   return instance
               }
           }
        }
    }

}