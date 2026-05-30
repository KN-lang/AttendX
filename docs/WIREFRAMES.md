# Wireframe Descriptions

This document describes the layout of the key screens in the AttendX Android app.

## 1. Dashboard Screen
Top Bar: "AttendX" title and Profile icon.
Content:
* Total Attendance Card: Big circular progress bar with overall percentage.
* Subject List:
    * Each item is a card.
    * Left side: Subject Name.
    * Center: Progress bar (Linear).
    * Right side: Current % and "Safe Bunks: X".
Floating Action Button (FAB): "+" to add a new subject.

## 2. Subject Details Screen
Top Bar: Subject Name with Back button.
Content:
* Stats Overview:
    * Current % (Large text).
    * "Attended: 15 | Total: 20".
* Safe Bunk Status:
    * "You can bunk **3** more classes." (Green if safe).
    * "You need to attend **5** more classes." (Red if below target).
* Quick Mark:
    * Three buttons: [Attended] [Missed] [Cancelled].
* Recent Activity: List of the last 5 attendance entries.
* Button: "View Full History".

## 3. Add/Edit Subject Screen
* Input: Subject Name (Text field).
* Input: Target Percentage (Slider or Number field, default 75%).
* Button: "Save Subject".
* Button: "Delete Subject" (Only in Edit mode).

## 4. History Screen
Top Bar: "Attendance History - [Subject Name]".
Content:
* List of entries grouped by month/week.
* Each entry shows:
    * Date.
    * Status (Icon + Text).
    * Optional Note snippet.
* Tap entry to open a bottom sheet for editing/deleting.

## 5. Profile & Settings Screen
* User Info: Avatar, Email, Username.
* Global Settings:
    * Default Target Percentage.
    * Theme (Light/Dark/System).
* Account: "Logout" button.
* About: App version and links to Landing Page/Legal.
