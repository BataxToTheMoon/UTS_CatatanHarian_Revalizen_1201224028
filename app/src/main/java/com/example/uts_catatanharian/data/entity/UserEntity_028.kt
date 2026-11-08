package com.example.uts_catatanharian.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_028")
data class UserEntity_028(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val username: String,
    val passwordHash: String,
    val salt: String
)
