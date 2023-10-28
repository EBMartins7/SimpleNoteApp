@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.simplenoteapp.ui.screen.note

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplenoteapp.ui.theme.CustomColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    state: NoteState,
    onEvent: (NoteEvent) -> Unit
) {
    Scaffold(
        containerColor = Color.DarkGray,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                        Text(
                            text = "Note",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                                fontWeight = FontWeight.Bold
                            )
                        )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onEvent(NoteEvent.NavigateBack)
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Navigate back",
                            tint = CustomColor
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        onEvent(NoteEvent.DeleteNote)
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = "Delete",
                            tint = CustomColor
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.DarkGray
                )
            )
        }
    ) { padding ->
        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(
                            horizontal = 20.dp,
                            vertical = 15.dp,
                        )
                        .padding(top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    OutlinedTextField(
                        value = state.title,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .border(0.dp, Color.DarkGray),
                        onValueChange = {
                            onEvent(NoteEvent.TitleChange(it))
                        },
                        placeholder = {
                            Text(
                                text = "Title",
                                color = Color.LightGray,
                                style = TextStyle(
                                    fontSize = 20.sp
                                )
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.DarkGray,
                            unfocusedContainerColor = Color.DarkGray
                        ),
                        enabled = true
                    )
                    OutlinedTextField(
                        value = state.content,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .border(0.dp, Color.DarkGray),
                        onValueChange = {
                            onEvent(NoteEvent.ContentChange(it))
                        },
                        placeholder = {
                            Text(
                                text = "Note something down",
                                color = Color.LightGray
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.DarkGray,
                            unfocusedContainerColor = Color.DarkGray
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = {
                                onEvent(NoteEvent.Save)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = CustomColor,
                                disabledContainerColor = CustomColor
                            ),
                            modifier = Modifier.fillMaxWidth(0.5f)
                        ) {
                            Text(
                                text = "Save",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NoteScreenPreview() {

}