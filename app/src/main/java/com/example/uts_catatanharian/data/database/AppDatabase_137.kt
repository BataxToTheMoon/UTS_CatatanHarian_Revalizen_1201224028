package com.example.uts_catatanharian.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uts_catatanharian.data.dao.NoteDao_137
import com.example.uts_catatanharian.data.dao.UserDao_028
import com.example.uts_catatanharian.data.entity.NoteEntity_088
import com.example.uts_catatanharian.data.entity.UserEntity_028

@Database(entities = [UserEntity_028::class, NoteEntity_088::class], version = 1, exportSchema = false)
abstract class AppDatabase_137 : RoomDatabase() {
    abstract fun userDao_028(): UserDao_028
    abstract fun noteDao_137(): NoteDao_137

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase_137? = null

        fun getDatabase_137(context: Context): AppDatabase_137 {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase_137::class.java,
                    "catatan_harian_db_137"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
