package com.attendx.app.attendance.domain.usecase

import com.attendx.app.attendance.domain.model.AttendanceStatus
import com.attendx.app.attendance.domain.repository.AttendanceRepository

class MarkAttendanceUseCase(
    private val repository: AttendanceRepository,
) {
    operator fun invoke(subjectId: String, status: AttendanceStatus) {
        repository.markAttendance(subjectId, status)
    }
}
