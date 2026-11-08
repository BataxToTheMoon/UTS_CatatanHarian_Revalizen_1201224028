package com.example.uts_catatanharian.data.repository

import com.example.uts_catatanharian.data.dao.NoteDao_137
import com.example.uts_catatanharian.data.entity.NoteEntity_088
import kotlinx.coroutines.flow.Flow

class NoteRepository_137(private val noteDao: NoteDao_137) {
    suspend fun insertNote_137(note: NoteEntity_088): Long {
        return noteDao.insertNote_137(note)
    }

    suspend fun updateNote_137(note: NoteEntity_088): Int {
        return noteDao.updateNote_137(note)
    }

    suspend fun deleteNote_137(noteId: Long, userId: Long): Int {
        return noteDao.deleteNoteById_137(noteId, userId)
    }

    fun getAllNotes_137(userId: Long): Flow<List<NoteEntity_088>> {
        return noteDao.getAllNotesByUser_137(userId)
    }

    suspend fun getNoteById_137(noteId: Long, userId: Long): NoteEntity_088? {
        return noteDao.getNoteByIdAndUser_137(noteId, userId)
    }

    suspend fun getNoteCount_137(userId: Long): Int {
        return noteDao.getNoteCountByUser_137(userId)
    }
}
