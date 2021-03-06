package com.autos.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.autos.model.Auto

@Database(entities = [Auto::class], version = 1, exportSchema = false)
abstract class AutoDatabase : RoomDatabase() {
    abstract fun autoDao(): AutoDao

    companion object {

        @Volatile
        private var INSTANCE: AutoDatabase? = null

        fun getDatabase(context: android.content.Context): AutoDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AutoDatabase::class.java,
                    "auto_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}