# Architecture Overview

AttendX follows a modern, scalable architecture designed for high performance and maintainability.

## 1. High-Level Design
AttendX is a **mobile-first** application. The primary user interface is the native Android app, while the Next.js web app serves as a marketing landing page.

### Components:
* **Android App:** Kotlin + Jetpack Compose.
* **Backend as a Service (BaaS):** Supabase (Authentication, PostgreSQL Database, Row-Level Security).
* **Landing Page:** Next.js + shadcn/ui.

## 2. Mobile Architecture (Android)
We adhere to the **Clean Architecture** principles combined with **MVVM (Model-View-ViewModel)**.

### Layers:
* **Data Layer:** Handles data retrieval from Supabase (via Retrofit/Ktor or Supabase SDK) and local caching (Room DB).
* **Domain Layer:** Contains business logic, Use Cases, and Entities. It is independent of other layers.
* **UI/Presentation Layer:** Jetpack Compose for UI and ViewModels to manage state.

## 3. Data Strategy
* **Offline First:** Users should be able to mark attendance even without an internet connection. Data is cached locally and synchronized with Supabase when online.
* **Supabase Integration:** Supabase provides secure authentication and a managed PostgreSQL database. It handles data persistence and synchronization across devices.

## 4. Landing Page Role
The Next.js landing page is strictly for:
* Product showcasing.
* Feature overview.
* Providing links to the Google Play Store.
* Legal documentation (Privacy Policy, Terms of Service).

## 5. Why no Docker? (v1)
For the current version (v1), we are leveraging managed services (Supabase Cloud, Vercel). This eliminates the need for managing our own infrastructure, containers, or CI/CD pipelines for a custom backend. This allows us to focus entirely on the mobile experience and rapid iteration.

## 6. Future Backend Possibility
While Supabase covers our current needs, the Clean Architecture setup allows us to swap the data layer with a custom backend (e.g., Node.js/Go) if we require more complex server-side logic in the future.
