package com.example.uts_catatanharian.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.uts_catatanharian.data.entity.UserEntity_028

@Dao
interface UserDao_028 {
    @Insert
    suspend fun registerUser_028(user: UserEntity_028): Long

    @Query("SELECT * FROM users_028 WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername_028(username: String): UserEntity_028?

    @Query("SELECT * FROM users_028 WHERE id = :userId LIMIT 1")
    suspend fun getUserById_028(userId: Long): UserEntity_028?
}
