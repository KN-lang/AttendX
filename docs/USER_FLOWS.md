# User Flows

## 1. Onboarding & Authentication
1. User opens the app.
2. If not logged in, user sees a splash screen followed by Login/Sign-up options.
3. User signs up via Email or Social Auth.
4. User completes a brief onboarding:
    * Sets their global target attendance percentage (default 75%).
    * Adds their first few subjects.
5. User arrives at the Dashboard.

## 2. Managing Subjects
1. User clicks "Add Subject" on the Dashboard.
2. User enters subject name and (optional) a specific target percentage.
3. User saves, and the subject appears on the Dashboard with 0% attendance.
4. User can long-press or click a "Settings" icon to edit or delete a subject.

## 3. Marking Attendance
1. User clicks on a subject card from the Dashboard.
2. User sees a summary and a "Mark Today's Attendance" section.
3. User selects "Attended", "Missed", or "Cancelled".
4. The dashboard and subject details update immediately.
5. (Optional) User can add a note to the record.

## 4. Calculating Safe Bunks
1. On the subject details screen, the app displays:
    * Current Percentage.
    * Classes attended/total.
    * **"Safe to Bunk"**: The number of upcoming classes the user can skip while staying above their target.
    * **"Need to Attend"**: If below target, how many consecutive classes they must attend to reach the target.

## 5. Viewing History
1. User selects a subject.
2. User clicks on "Attendance History".
3. User sees a list of past dates with the status (Attended/Missed/Cancelled).
4. User can tap an entry to edit or delete it.
