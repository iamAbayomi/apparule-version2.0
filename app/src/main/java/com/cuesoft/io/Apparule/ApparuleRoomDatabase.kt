package com.cuesoft.io.apparule

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cuesoft.io.apparule.dao.CustomerDao
import com.cuesoft.io.apparule.model.Customer

@Database(entities = [Customer::class], version = 1)
abstract class ApparuleRoomDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object{
        //Singleton prevents multiple instances of database opeining at the
        // same time.
        @Volatile
        private var INSTANCE: ApparuleRoomDatabase? = null

        fun getDatabase(context: Context): ApparuleRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ApparuleRoomDatabase::class.java,
                    "apparule_database"
                ).build()
                INSTANCE = instance

                return instance
            }
        }
    }
}