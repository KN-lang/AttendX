# Database Schema (Supabase/PostgreSQL)

AttendX uses Supabase PostgreSQL for data storage. Below is the schema for v1.

## Tables

### 1. `profiles`
Stores additional user information.
* `id`: UUID (Primary Key, references `auth.users`)
* `username`: Text (Unique)
* `full_name`: Text
* `avatar_url`: Text
* `target_percentage`: Integer (Default: 75)
* `updated_at`: Timestamp with time zone

### 2. `subjects`
Stores subjects tracked by the user.
* `id`: UUID (Primary Key, Default: `uuid_generate_v4()`)
* `user_id`: UUID (Foreign Key, references `profiles.id`)
* `name`: Text (Not Null)
* `target_percentage`: Integer (Overrides user default if set)
* `created_at`: Timestamp with time zone

### 3. `attendance_records`
Stores individual attendance logs.
* `id`: UUID (Primary Key, Default: `uuid_generate_v4()`)
* `user_id`: UUID (Foreign Key, references `profiles.id`)
* `subject_id`: UUID (Foreign Key, references `subjects.id`, On Delete: Cascade)
* `status`: Text (Enum: 'attended', 'missed', 'cancelled')
* `date`: Date (Not Null)
* `note`: Text
* `created_at`: Timestamp with time zone

### 4. `timetable_entries` (Future)
Planned for v2 to store the user's weekly schedule.
* `id`: UUID (Primary Key)
* `user_id`: UUID (Foreign Key)
* `subject_id`: UUID (Foreign Key)
* `day_of_week`: Integer (0-6)
* `start_time`: Time
* `end_time`: Time

## Row Level Security (RLS)
All tables will have RLS enabled.
* Users can only read/write their own data (`user_id = auth.uid()`).
* Policies will be applied to each table to ensure data privacy.
