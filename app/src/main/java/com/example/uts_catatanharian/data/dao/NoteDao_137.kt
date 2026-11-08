package com.example.uts_catatanharian.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.uts_catatanharian.data.entity.NoteEntity_088
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao_137 {
    @Insert
    suspend fun insertNote_137(note: NoteEntity_088): Long

    @Update
    suspend fun updateNote_137(note: NoteEntity_088): Int

    @Query("DELETE FROM notes_088 WHERE id = :noteId AND user_id = :userId")
    suspend fun deleteNoteById_137(noteId: Long, userId: Long): Int

    @Query("SELECT * FROM notes_088 WHERE user_id = :userId ORDER BY tanggal DESC")
    fun getAllNotesByUser_137(userId: Long): Flow<List<NoteEntity_088>>

    @Query("SELECT * FROM notes_088 WHERE id = :noteId AND user_id = :userId LIMIT 1")
    suspend fun getNoteByIdAndUser_137(noteId: Long, userId: Long): NoteEntity_088?

    @Query("SELECT COUNT(*) FROM notes_088 WHERE user_id = :userId")
    suspend fun getNoteCountByUser_137(userId: Long): Int
}
