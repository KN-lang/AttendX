package com.attendx.app.attendance.presentation.dashboard

data class AddSubjectUiState(
    val subjectName: String = "",
    val facultyName: String = "",
    val requiredPercentage: String = "75",
    val subjectNameError: String? = null,
    val requiredPercentageError: String? = null,
)
