package com.attendx.app.attendance.data.repository

import com.attendx.app.attendance.domain.model.SubjectAttendance
import com.attendx.app.attendance.domain.repository.AttendanceRepository

class InMemoryAttendanceRepository : AttendanceRepository {
    private val subjects = mutableListOf(
        SubjectAttendance(id = "mathematics", name = "Mathematics", attendedClasses = 32, totalClasses = 38),
        SubjectAttendance(id = "physics", name = "Physics", attendedClasses = 24, totalClasses = 32),
        SubjectAttendance(id = "chemistry", name = "Chemistry", attendedClasses = 19, totalClasses = 29),
    )

    override fun getSubjects(): List<SubjectAttendance> = subjects.toList()

    override fun addSubject(subject: SubjectAttendance) {
        subjects.add(subject)
    }
}
