package com.attendx.app.attendance.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.attendx.app.attendance.data.repository.InMemoryAttendanceRepository
import com.attendx.app.attendance.domain.usecase.GetAttendanceSummaryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AttendanceDashboardViewModel(
    getAttendanceSummary: GetAttendanceSummaryUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        AttendanceDashboardUiState(summary = getAttendanceSummary()),
    )
    val uiState: StateFlow<AttendanceDashboardUiState> = _uiState.asStateFlow()

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = InMemoryAttendanceRepository()
                return AttendanceDashboardViewModel(
                    getAttendanceSummary = GetAttendanceSummaryUseCase(repository),
                ) as T
            }
        }
    }
}

