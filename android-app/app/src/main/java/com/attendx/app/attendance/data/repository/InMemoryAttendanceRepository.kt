package com.attendx.app.attendance.data.repository

import com.attendx.app.attendance.domain.model.AttendanceStatus
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

    override fun markAttendance(subjectId: String, status: AttendanceStatus) {
        val index = subjects.indexOfFirst { it.id == subjectId }

        if (index == -1) return

        val subject = subjects[index]

        val updatedSubject = when (status) {
            AttendanceStatus.PRESENT -> subject.copy(
                attendedClasses = subject.attendedClasses + 1,
                totalClasses = subject.totalClasses + 1,
            )

            AttendanceStatus.ABSENT -> subject.copy(
                totalClasses = subject.totalClasses + 1,
            )

            AttendanceStatus.CANCELLED -> subject
        }

        subjects[index] = updatedSubject
    }
}
