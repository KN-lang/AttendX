package com.attendx.app.attendance.domain.model

data class AttendanceSummary(
    val subjects: List<SubjectAttendance>,
    val overallPercentage: Int,
    val totalSafeBunks: Int,
    val riskStatus: RiskStatus,
)

