# Hands-On 2: Data Binding, Lifecycle Hooks & Component Communication

## Problem Description
Make the Student Course Portal dynamic by implementing string interpolation, property binding, event binding, and two-way binding. Implement lifecycle hooks (`ngOnInit`, `ngOnDestroy`, `ngOnChanges`) to monitor component creation, destruction, and parameter updates. Establish component communication between parent (`CourseListComponent`) and child (`CourseCardComponent`) using `@Input` and `@Output` parameters.

## Topics Covered
- One-way and Two-way Data Binding configurations
- Component lifecycle hook interfaces
- Inter-component communication via inputs and output event emitters

## Implementation Details
- **Data Binding (Home Component)**:
  - Bound the heading to `portalName` via interpolation.
  - Bound button disabled state to `isPortalActive`.
  - Configured click events to display a success message when enrollment begins.
  - Configured the course search text box with two-way binding using `[(ngModel)]` (importing `FormsModule`).
- **Lifecycle Hooks**:
  - Implemented `ngOnInit` and `ngOnDestroy` logs inside `HomeComponent`.
  - Implemented `ngOnChanges` inside `CourseCardComponent` to log previous and current values.
- **Parent-Child Communication**:
  - `CourseCardComponent` receives a `course` object via `@Input` and exposes `enrollRequested` event via `@Output`.
  - `CourseListComponent` renders 5 course cards using `*ngFor` and handles their enrollment clicks to show the selected ID.
