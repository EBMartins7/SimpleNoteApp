package com.example.simplenoteapp.data.mapper

import com.example.simplenoteapp.data.local.entity.NoteEntity
import com.example.simplenoteapp.domain.model.Note

fun NoteEntity.asExternalModel(): Note = Note(
    id, title, content
)

fun Note.toEntity(): NoteEntity = NoteEntity(
    id, title, content
)

