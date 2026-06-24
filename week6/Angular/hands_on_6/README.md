# Hands-On 6: Services & Dependency Injection

## Problem Description
Decentralize state and business logic from components into injectable Angular services. Build a singleton `CourseService` and `EnrollmentService` (utilizing service-to-service injection), and demonstrate hierarchical injection behavior by providing a scoped `NotificationService` instance within a component context.

## Topics Covered
- Singleton Services using `@Injectable({ providedIn: 'root' })`
- Service-to-Service Dependency Injection
- Component-level Providers (`providers: [...]`) and hierarchical token scopes

## Implementation Details
- **Course Service**:
  - Exposes an array of courses, details by ID, and support for adding new courses.
- **Enrollment Service**:
  - Injects `CourseService` to resolve enrolled course IDs to full model structures.
  - Exposes methods `enroll()`, `unenroll()`, `isEnrolled()`, and `getEnrolledCourses()`.
- **Shared State Verification**:
  - Added `CourseSummaryWidget` component to verify that updates made by enrolling in courses reflect instantly across all widgets, proving singleton instantiation.
- **Hierarchical Injection**:
  - Provided `NotificationService` inside the `NotificationComponent` metadata, isolating its state and logs from other potential notifications instances in the application.
