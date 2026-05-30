package com.attendx.app.attendance.presentation.dashboard

import com.attendx.app.attendance.domain.model.AttendanceSummary
import com.attendx.app.attendance.domain.model.RiskStatus

data class AttendanceDashboardUiState(
    val summary: AttendanceSummary = AttendanceSummary(
        subjects = emptyList(),
        overallPercentage = 0,
        totalSafeBunks = 0,
        riskStatus = RiskStatus.SAFE,
    ),
)

