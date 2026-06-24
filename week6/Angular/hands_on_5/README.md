# Hands-On 5: Reactive Forms — FormBuilder, FormGroup, FormArray & Custom Validators

## Problem Description
Implement a robust Student Enrollment Form using Angular's Reactive Forms model. Utilize the `FormBuilder` to construct form states, add custom validators (both synchronous and asynchronous), and integrate a dynamic `FormArray` that allows users to request additional courses on demand.

## Topics Covered
- Reactive forms initialization (`FormGroup`, `FormControl`, `FormBuilder`)
- Custom synchronous validators (validating prefix constraints)
- Custom asynchronous validators (simulating API queries via promises)
- Dynamic repeating sections via `FormArray` and typed component getters

## Implementation Details
- **Reactive Form Construction**:
  - Initialized form fields with validation constraints using `fb.group()`.
  - Added comments documenting the difference between `form.value` and `form.getRawValue()`.
- **Custom Validators**:
  - `noCourseCode`: Prevents submitting a course ID code that starts with 'XX'.
  - `simulateEmailCheck`: Evaluates email availability after a simulated latency of 800ms, raising an error if email matches 'test@'.
- **Dynamic Array**:
  - `additionalCourses` FormArray: Enables users to dynamically add/remove input fields representing extra courses.
  - Implemented getter `additionalCourses` returning `FormArray` for safe type resolution.
