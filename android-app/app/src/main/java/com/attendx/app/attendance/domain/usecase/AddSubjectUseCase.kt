package com.attendx.app.attendance.domain.usecase

import com.attendx.app.attendance.domain.model.SubjectAttendance
import com.attendx.app.attendance.domain.repository.AttendanceRepository
import java.util.UUID

class AddSubjectUseCase(
    private val repository: AttendanceRepository,
) {
    operator fun invoke(
        name: String,
        facultyName: String?,
        requiredPercentage: Int,
    ) {
        require(name.isNotBlank()) { "Subject name cannot be empty." }
        require(requiredPercentage in 1..100) { "Required attendance must be between 1 and 100." }

        repository.addSubject(
            SubjectAttendance(
                id = UUID.randomUUID().toString(),
                name = name.trim(),
                facultyName = facultyName?.trim()?.takeIf { it.isNotEmpty() },
                requiredPercentage = requiredPercentage,
                attendedClasses = 0,
                totalClasses = 0,
            ),
        )
    }
}
