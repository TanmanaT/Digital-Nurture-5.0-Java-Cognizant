# Hands-On 7: Angular Routing — Guards, Lazy Loading & Route Data

## Problem Description
Configure full client-side SPA routing for the Student Course Portal. Set up dynamic route parameters (`/courses/:id`) to display specific syllabus info, manage nested routes, implement a wildcard path fallback for 404 screens, protect routing paths using functional guards (`CanActivate` and `CanDeactivate`), and enable lazy loading for the enrollment feature module.

## Topics Covered
- Nested routes with layout components hosting child `<router-outlet>` views
- Query parameter updates (`/courses?search=angular`)
- Route parameter extraction via `ActivatedRoute` snapshots
- Feature modules and lazy loaded bundles (`loadChildren`)
- Route guards (`canActivate` for authentication, `canDeactivate` for unsaved forms)

## Implementation Details
- **Nested & Detail Routing**:
  - Organized `/courses` under `CoursesLayoutComponent`, loading `CourseListComponent` on base load and `CourseDetailComponent` on parameterized match (`/courses/:id`).
  - Handled input search filters by updating query parameters via `Router.navigate()`.
- **Wildcard Path Fallback**:
  - Registered `NotFoundComponent` for path `**` displaying a premium 404 screen.
- **Lazy Loading**:
  - Created feature module `EnrollmentModule` containing enrollment components and routing rules. Registered it under `/enroll` via `loadChildren()`.
- **Route Guards**:
  - `authGuard`: Protects profile and enrollment routes by checking mock authentication state.
  - `unsavedChangesGuard`: Triggers a browser confirmation alert if leaving the reactive enrollment form when it is dirty.
