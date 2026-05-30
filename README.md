# AttendX

AttendX is a professional, native Android attendance tracking app designed for students. It helps you stay on top of your attendance, calculate safe bunks, and ensure you never fall below the required attendance percentage.

## Features

* **Subject-wise Tracking:** Monitor attendance for each subject individually.
* **Safe Bunk Calculator:** Know exactly how many classes you can skip without falling below your target percentage.
* **Attendance Goals:** Set your desired attendance percentage and track your progress.
* **Daily Logs:** Easy-to-use interface to mark attendance for each class.
* **Timetable Integration (Planned):** Automatic prompts to mark attendance based on your schedule.

## Tech Stack

* **Mobile App:** Native Android (Kotlin + Jetpack Compose)
* **Backend & Auth:** [Supabase](https://supabase.com/) (Auth, PostgreSQL Database)
* **Landing Page:** [Next.js](https://nextjs.org/) + [shadcn/ui](https://ui.shadcn.com/)
* **Deployment:** 
    * Android: Google Play Store
    * Landing Page: Vercel
    * Database: Supabase Cloud

## Project Structure

```text
AttendX/
├── android-app/     # Native Android application (Kotlin/Compose)
├── landing-page/    # Next.js landing page
├── docs/            # Project documentation
├── README.md        # This file
├── LICENSE          # MIT License
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
├── SECURITY.md
└── .gitignore
```

## Current Development Status

AttendX is currently in the **foundation phase**. We are setting up the core architecture and documentation.

## Roadmap

See the full [Roadmap](docs/ROADMAP.md) for upcoming features and milestones.

## Contribution Guide

We welcome contributions! Please see our [CONTRIBUTING.md](CONTRIBUTING.md) for details.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
