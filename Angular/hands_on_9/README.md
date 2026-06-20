# Hands-On 9: State Management with NgRx Store

## Problem Description
Migrate local component state management and service-level data caching to a central Redux-style store using NgRx. Install and configure `@ngrx/store`, `@ngrx/effects`, and `@ngrx/store-devtools`. Define state, actions, reducers, effects, and selectors to manage course data loading and student enrollment requests.

## Topics Covered
- Redux design patterns in Angular
- Action Creators (`createAction`) and Reducers (`createReducer`)
- Selector queries (`createSelector`, `createFeatureSelector`)
- Async side effects (`createEffect`) with RxJS routing
- NgRx Store DevTools debugging configuration

## Implementation Details
- **Store Configuration**:
  - Configured providers inside `appConfig` using `provideStore`, `provideEffects`, and `provideStoreDevtools`.
- **NgRx Store Setup**:
  - `course.actions.ts`: Outlined course fetch operations (`loadCourses`, `loadCoursesSuccess`, `loadCoursesFailure`) and enrollments (`enrollCourse`, `unenrollCourse`).
  - `course.reducer.ts`: Tracks state for `courses`, `loading`, `error`, and `enrolledCourseIds`.
  - `course.selectors.ts`: Selects all courses, enrolled IDs, loading/error flags, and compiles the joined lists reactively.
  - `course.effects.ts`: Intercepts `loadCourses` to load from `CourseService` and map API data back to store actions.
- **Component Refactoring**:
  - `CourseList`: Dispatches `loadCourses` on base initialize and combines query parameters with store selectors using `combineLatest`.
  - `CourseCard`: Binds `isEnrolled` to the store and dispatches enrollment actions.
  - `CourseSummaryWidget` & `Home`: Subscribe to selectors for reactive metrics.
