package com.example.uts_catatanharian.data.repository

import com.example.uts_catatanharian.data.dao.UserDao_028
import com.example.uts_catatanharian.data.entity.UserEntity_028

class UserRepository_028(private val userDao: UserDao_028) {
    suspend fun registerUser_028(user: UserEntity_028): Long {
        return userDao.registerUser_028(user)
    }

    suspend fun getUserByUsername_028(username: String): UserEntity_028? {
        return userDao.getUserByUsername_028(username)
    }

    suspend fun getUserById_028(userId: Long): UserEntity_028? {
        return userDao.getUserById_028(userId)
    }
}
