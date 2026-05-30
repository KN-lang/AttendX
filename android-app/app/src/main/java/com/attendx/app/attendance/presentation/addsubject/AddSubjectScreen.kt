package com.attendx.app.attendance.presentation.addsubject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.attendx.app.attendance.presentation.dashboard.AddSubjectUiState
import com.attendx.app.core.theme.MutedInk

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSubjectScreen(
    uiState: AddSubjectUiState,
    onSubjectNameChange: (String) -> Unit,
    onFacultyNameChange: (String) -> Unit,
    onRequiredPercentageChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Add subject") },
                navigationIcon = {
                    TextButton(onClick = onBackClick) {
                        Text(text = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "Create a subject",
                        style = MaterialTheme.typography.headlineLarge,
                    )
                    Text(
                        text = "Add the details you need to track attendance.",
                        color = MutedInk,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
            item {
                OutlinedTextField(
                    value = uiState.subjectName,
                    onValueChange = onSubjectNameChange,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Subject name") },
                    placeholder = { Text(text = "e.g. Computer Science") },
                    singleLine = true,
                    isError = uiState.subjectNameError != null,
                    supportingText = uiState.subjectNameError?.let { error ->
                        { Text(text = error) }
                    },
                )
            }
            item {
                OutlinedTextField(
                    value = uiState.facultyName,
                    onValueChange = onFacultyNameChange,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Faculty name (optional)") },
                    placeholder = { Text(text = "e.g. Dr. Sharma") },
                    singleLine = true,
                )
            }
            item {
                OutlinedTextField(
                    value = uiState.requiredPercentage,
                    onValueChange = onRequiredPercentageChange,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Required attendance percentage") },
                    suffix = { Text(text = "%") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    isError = uiState.requiredPercentageError != null,
                    supportingText = {
                        Text(
                            text = uiState.requiredPercentageError
                                ?: "Choose a value between 1 and 100.",
                        )
                    },
                )
            }
            item {
                Button(
                    onClick = onSaveClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    contentPadding = PaddingValues(vertical = 15.dp),
                ) {
                    Text(text = "Save subject")
                }
            }
        }
    }
}
