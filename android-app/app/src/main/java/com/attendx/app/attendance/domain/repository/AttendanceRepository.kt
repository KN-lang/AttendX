package com.attendx.app.attendance.domain.repository

import com.attendx.app.attendance.domain.model.SubjectAttendance

interface AttendanceRepository {
    fun getSubjects(): List<SubjectAttendance>

    fun addSubject(subject: SubjectAttendance)
}
