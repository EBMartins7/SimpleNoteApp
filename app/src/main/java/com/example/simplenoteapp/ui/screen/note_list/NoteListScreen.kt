package com.example.simplenoteapp.ui.screen.note_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenoteapp.domain.model.Note
import com.example.simplenoteapp.ui.theme.CustomColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(
    noteList: List<Note>,
    onNoteClick: (Note) -> Unit,
    onAddNoteClick: () -> Unit
) {

    Scaffold(
        topBar = {
            LargeTopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.DarkGray
                ),
                title = {
                    Text(
                        text = "Notepad",
                        style = TextStyle(
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteClick,
                containerColor = CustomColor,
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add note",
                    tint = Color.Black
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray),
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = 15.dp + padding.calculateTopPadding(),
                bottom = 15.dp + padding.calculateBottomPadding()
            )
        ) {
            items(noteList) {note ->
                ListItem(
                    headlineContent = {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    },
                    supportingContent = {
                        Text(
                            text = note.content,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )
                    },
                    modifier = Modifier.clickable(
                        onClick = {
                        onNoteClick(note)
                    }),
                    colors = ListItemDefaults.colors(
                        containerColor = Color.DarkGray
                    ),
                    tonalElevation = 10.dp,
                    shadowElevation = 10.dp
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NoteListScreenPreview() {
    val noteList: List<Note> = emptyList()
    NoteListScreen(noteList = noteList, onNoteClick = {}, onAddNoteClick = {})
}