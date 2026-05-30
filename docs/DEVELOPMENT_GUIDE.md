# Development Guide

Welcome to the AttendX development team! This guide will help you get started with the project.

## 1. Prerequisites
Ensure you have the following installed:
* **Android Studio** (Latest Hedgehog or Iguana recommended).
* **JDK 17** (Used for Android development).
* **Node.js 18+** (For the landing page).
* **Git**.

## 2. Setting Up the Android App
1. Open Android Studio.
2. Select "Open" and navigate to the `android-app/` directory.
3. Wait for Gradle to sync.
4. Create a `local.properties` file in the root of `android-app/` if it doesn't exist.
5. You will need Supabase credentials (API Key and URL). Add them to `local.properties` (we will use a custom Gradle task to inject these into the app).

## 3. Setting Up the Landing Page
1. Navigate to the `landing-page/` directory: `cd landing-page`.
2. Install dependencies: `npm install`.
3. Start the development server: `npm run dev`.
4. Open [http://localhost:3000](http://localhost:3000) in your browser.

## 4. Supabase Setup
1. Create a free account at [supabase.com](https://supabase.com/).
2. Create a new project named "AttendX".
3. Run the SQL scripts found in `docs/DATABASE_SCHEMA.md` in the Supabase SQL Editor to set up your tables.
4. Enable Email/Password authentication in the Supabase Auth settings.

## 5. Coding Standards
* **Kotlin:** We follow the official [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html).
* **Compose:** Use `State` and `MutableState` properly. Keep Composables small and focused.
* **Architecture:** Strictly follow MVVM. ViewModels should not have any Android framework dependencies (use Hilt for injection).

## 6. Git Workflow
* **Main Branch:** Protected. All changes must come through a Pull Request.
* **Feature Branches:** Use `feature/feature-name`.
* **Bug Fix Branches:** Use `fix/bug-name`.
* **Commits:** Follow conventional commits (e.g., `feat: add subject logging`, `fix: dashboard crash`).

## 7. Testing
* **Unit Tests:** Write unit tests for business logic in the Domain layer.
* **UI Tests:** Use Compose Test library for critical UI flows.
* Run tests before submitting a PR: `./gradlew test`.
