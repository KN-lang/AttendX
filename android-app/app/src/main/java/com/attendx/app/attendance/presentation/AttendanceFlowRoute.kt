package com.attendx.app.attendance.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.attendx.app.attendance.presentation.addsubject.AddSubjectScreen
import com.attendx.app.attendance.presentation.dashboard.AttendanceDashboardScreen
import com.attendx.app.attendance.presentation.dashboard.AttendanceDashboardViewModel

private enum class AttendanceScreen {
    DASHBOARD,
    ADD_SUBJECT,
}

@Composable
fun AttendanceFlowRoute(
    viewModel: AttendanceDashboardViewModel = viewModel(factory = AttendanceDashboardViewModel.Factory),
) {
    var currentScreen by rememberSaveable { mutableStateOf(AttendanceScreen.DASHBOARD) }
    val dashboardUiState by viewModel.uiState.collectAsState()
    val addSubjectUiState by viewModel.addSubjectUiState.collectAsState()

    fun returnToDashboard() {
        viewModel.resetAddSubjectForm()
        currentScreen = AttendanceScreen.DASHBOARD
    }

    when (currentScreen) {
        AttendanceScreen.DASHBOARD -> AttendanceDashboardScreen(
            uiState = dashboardUiState,
            onAddSubjectClick = { currentScreen = AttendanceScreen.ADD_SUBJECT },
            onMarkAttendance = viewModel::onMarkAttendance,
        )

        AttendanceScreen.ADD_SUBJECT -> {
            BackHandler(onBack = ::returnToDashboard)
            AddSubjectScreen(
                uiState = addSubjectUiState,
                onSubjectNameChange = viewModel::onSubjectNameChange,
                onFacultyNameChange = viewModel::onFacultyNameChange,
                onRequiredPercentageChange = viewModel::onRequiredPercentageChange,
                onSaveClick = {
                    if (viewModel.saveSubject()) {
                        currentScreen = AttendanceScreen.DASHBOARD
                    }
                },
                onBackClick = ::returnToDashboard,
            )
        }
    }
}
