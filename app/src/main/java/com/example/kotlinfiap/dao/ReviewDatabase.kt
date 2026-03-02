package com.example.kotlinfiap.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinfiap.model.User

@Database(
    entities = [User::class],
    version = 1,
)
abstract class ReviewDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        private lateinit var instance:  ReviewDatabase
        fun getDatabase(context: Context): ReviewDatabase {
            if(!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        ReviewDatabase::class.java,
                        "review_database"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

    }

}

