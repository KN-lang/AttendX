# Product Requirements Document (PRD) - AttendX

## 1. Executive Summary
AttendX is a native Android application designed to help students track their class attendance efficiently. The primary goal is to provide a clear overview of attendance status across different subjects and help students make informed decisions about attending or bunking classes based on their target attendance percentage.

## 2. Problem Statement
Many students struggle to keep track of their attendance manually. Falling below the minimum required percentage can lead to academic penalties. Conversely, students often don't know exactly how many classes they *can* skip without dropping below the threshold.

## 3. Target Audience
* College and University students.
* Students with mandatory attendance requirements.

## 4. Key Features

### 4.1. Core Features (v1)
* **User Authentication:** Sign up/Login via email or social providers (via Supabase).
* **Subject Management:** Add, edit, and delete subjects with target attendance percentage (default 75%).
* **Attendance Logging:** Mark classes as "Attended", "Missed", or "Cancelled".
* **Attendance Dashboard:** Overview of current percentage for all subjects.
* **Safe Bunk Calculator:** Displays the number of classes a student can safely miss for each subject.
* **History/Log:** View a chronological log of attendance for each subject.

### 4.2. Future Features (v2+)
* **Timetable Integration:** Set up a weekly schedule.
* **Smart Notifications:** Reminders to mark attendance after class ends.
* **Cloud Sync:** Seamlessly sync data across devices.
* **Detailed Analytics:** Trends and monthly reports.

## 5. Technical Stack
* **Platform:** Native Android (Kotlin + Jetpack Compose)
* **Backend:** Supabase (Auth + PostgreSQL)
* **Architecture:** MVVM + Clean Architecture

## 6. User Personas
* **The "On the Edge" Student:** Frequently misses classes and needs to know exactly when they MUST attend to avoid debarment.
* **The "Planned Bunk" Student:** Wants to skip specific classes and needs to know if they have enough "buffer".

## 7. Success Metrics
* Active monthly users.
* Average number of subjects tracked per user.
* Retention rate after one semester.
