package com.attendx.app.attendance.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.attendx.app.attendance.data.repository.InMemoryAttendanceRepository
import com.attendx.app.attendance.domain.usecase.AddSubjectUseCase
import com.attendx.app.attendance.domain.usecase.GetAttendanceSummaryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AttendanceDashboardViewModel(
    private val getAttendanceSummary: GetAttendanceSummaryUseCase,
    private val addSubject: AddSubjectUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        AttendanceDashboardUiState(summary = getAttendanceSummary()),
    )
    val uiState: StateFlow<AttendanceDashboardUiState> = _uiState.asStateFlow()

    private val _addSubjectUiState = MutableStateFlow(AddSubjectUiState())
    val addSubjectUiState: StateFlow<AddSubjectUiState> = _addSubjectUiState.asStateFlow()

    fun onSubjectNameChange(value: String) {
        _addSubjectUiState.value = _addSubjectUiState.value.copy(
            subjectName = value,
            subjectNameError = null,
        )
    }

    fun onFacultyNameChange(value: String) {
        _addSubjectUiState.value = _addSubjectUiState.value.copy(facultyName = value)
    }

    fun onRequiredPercentageChange(value: String) {
        if (value.all(Char::isDigit)) {
            _addSubjectUiState.value = _addSubjectUiState.value.copy(
                requiredPercentage = value,
                requiredPercentageError = null,
            )
        }
    }

    fun saveSubject(): Boolean {
        val form = _addSubjectUiState.value
        val percentage = form.requiredPercentage.toIntOrNull()
        val subjectNameError = if (form.subjectName.isBlank()) "Subject name is required." else null
        val percentageError = if (percentage == null || percentage !in 1..100) {
            "Enter a percentage between 1 and 100."
        } else {
            null
        }

        if (subjectNameError != null || percentageError != null) {
            _addSubjectUiState.value = form.copy(
                subjectNameError = subjectNameError,
                requiredPercentageError = percentageError,
            )
            return false
        }

        addSubject(
            name = form.subjectName,
            facultyName = form.facultyName,
            requiredPercentage = checkNotNull(percentage),
        )
        _uiState.value = AttendanceDashboardUiState(summary = getAttendanceSummary())
        resetAddSubjectForm()
        return true
    }

    fun resetAddSubjectForm() {
        _addSubjectUiState.value = AddSubjectUiState()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = InMemoryAttendanceRepository()
                return AttendanceDashboardViewModel(
                    getAttendanceSummary = GetAttendanceSummaryUseCase(repository),
                    addSubject = AddSubjectUseCase(repository),
                ) as T
            }
        }
    }
}
