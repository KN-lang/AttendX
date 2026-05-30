package com.attendx.app.attendance.domain.model

import kotlin.math.floor

data class SubjectAttendance(
    val id: String,
    val name: String,
    val facultyName: String? = null,
    val attendedClasses: Int,
    val totalClasses: Int,
    val requiredPercentage: Int = 75,
) {
    val attendancePercentage: Int
        get() = if (totalClasses == 0) 0 else (attendedClasses * 100) / totalClasses

    val safeBunkCount: Int
        get() = if (totalClasses == 0) 0 else floor(
            (attendedClasses * 100.0 / requiredPercentage) - totalClasses,
        ).toInt().coerceAtLeast(0)

    val riskStatus: RiskStatus
        get() = when {
            totalClasses == 0 -> RiskStatus.SAFE
            attendancePercentage >= requiredPercentage -> RiskStatus.SAFE
            attendancePercentage >= requiredPercentage - 10 -> RiskStatus.WARNING
            else -> RiskStatus.CRITICAL
        }
}
