package com.attendx.app.attendance.domain.usecase

import com.attendx.app.attendance.domain.model.AttendanceSummary
import com.attendx.app.attendance.domain.model.RiskStatus
import com.attendx.app.attendance.domain.repository.AttendanceRepository

class GetAttendanceSummaryUseCase(
    private val repository: AttendanceRepository,
) {
    operator fun invoke(): AttendanceSummary {
        val subjects = repository.getSubjects()
        val attended = subjects.sumOf { it.attendedClasses }
        val total = subjects.sumOf { it.totalClasses }
        val overallPercentage = if (total == 0) 0 else (attended * 100) / total

        return AttendanceSummary(
            subjects = subjects,
            overallPercentage = overallPercentage,
            totalSafeBunks = subjects.sumOf { it.safeBunkCount },
            riskStatus = when {
                subjects.any { it.riskStatus == RiskStatus.CRITICAL } -> RiskStatus.CRITICAL
                subjects.any { it.riskStatus == RiskStatus.WARNING } -> RiskStatus.WARNING
                else -> RiskStatus.SAFE
            },
        )
    }
}

