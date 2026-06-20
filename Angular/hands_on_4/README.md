# Hands-On 4: Template-Driven Forms & Validation

## Problem Description
Build a Student Enrollment Request form using Angular's template-driven approach, add built-in validations (required, email, minlength), render validation messages, and capture the form data on submission.

## Topics Covered
- Template-driven forms using `#form="ngForm"`
- Two-way binding using `[(ngModel)]` in form elements
- Built-in HTML5 validators and Angular form state styling classes (`.ng-touched`, `.ng-invalid`, `.ng-valid`)

## Implementation Details
- **Form Fields**:
  - `studentName` (required, minlength="3")
  - `studentEmail` (required, email)
  - `courseId` (required)
  - `preferredSemester` (Odd/Even select)
  - `agreeToTerms` (required check)
- **Validation Messages**: Displayed conditionally when controls are touched and have active errors.
- **Dynamic Styling**: Styled invalid inputs with red borders and valid inputs with green borders once touched.
- **Form Actions**: Enabled submit only when all validations pass; reset clears fields and resets control state.
