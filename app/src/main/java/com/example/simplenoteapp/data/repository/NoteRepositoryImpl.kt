package com.example.simplenoteapp.data.repository

import com.example.simplenoteapp.data.local.dao.NoteDao
import com.example.simplenoteapp.data.mapper.asExternalModel
import com.example.simplenoteapp.data.mapper.toEntity
import com.example.simplenoteapp.domain.model.Note
import com.example.simplenoteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
            .map { notes ->
                notes.map {
                    it.asExternalModel()
                }
            }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.asExternalModel()
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.toEntity())
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note.toEntity())
    }
}