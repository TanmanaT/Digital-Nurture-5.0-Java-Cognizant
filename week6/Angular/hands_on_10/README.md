# Hands-On 10: Angular Unit Testing — Jasmine & TestBed

## Problem Description
Write unit tests to verify components and services in the Student Course Portal application. Configure the Angular testing utility `TestBed`, mock component inputs and outputs, verify DOM templates render property states, spy on component functions, utilize `HttpTestingController` to intercept HTTP client calls, and test store-connected components via `provideMockStore`.

## Topics Covered
- Angular testing architecture and `TestBed` configuration
- Unit testing components with `@Input` and `@Output` bindings
- Jasmine spies for function execution and verification
- Testing async operations and mapping filters on HTTP clients
- Mocking NgRx store connections inside specs

## Implementation Details
- **Component Tests (`course-card.component.spec.ts`)**:
  - Configured unit tests using `provideMockStore` to stub state selections.
  - Asserted correct rendering of course inputs.
  - Verified toggle operations properly update expansion states.
  - Tested that clicking action buttons dispatches actions (`enrollCourse` / `unenrollCourse`).
- **Service Tests (`course.service.spec.ts`)**:
  - Leveraged `provideHttpClientTesting` and `HttpTestingController` to mock backend API requests.
  - Verified GET request paths, mapped operations, and query assertions.
  - Tested creating courses via POST with precise payload validation.
