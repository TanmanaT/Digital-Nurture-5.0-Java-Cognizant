# Hands-On 8: Angular HttpClient — API Integration, RxJS & Interceptors

## Problem Description
Integrate HttpClient to replace static local service data with mock API servers using `json-server`. Configure custom functional HTTP interceptors for automatic authentication token injection, globally catching backend errors, and managing a reactive fullscreen application loading spinner. Leverage RxJS operators to optimize network requests and error pipelines.

## Topics Covered
- Angular HttpClient and API integration
- Custom functional interceptors (`HttpInterceptorFn`)
- RxJS operators: `map`, `catchError`, `tap`, `retry`, `switchMap`
- Global loading state tracking using a custom loading service

## Implementation Details
- **API Setup**:
  - Integrated `apiUrl = 'http://localhost:3000/courses'` under `CourseService`.
  - Configured subscriber streams reactively in page components.
- **RxJS Pipeline**:
  - Utilized `retry(2)` to automatically attempt refetching on network failures.
  - Used `tap` to perform logging side effects without altering downstream emission structures.
  - Applied `map` transformations to prune mock courses with 0 credits.
- **Interceptors**:
  - `authInterceptor`: Automatically appends a mock `Authorization: Bearer mock-token` header to all outgoing requests.
  - `errorHandlerInterceptor`: Catches request exceptions, logs them console-wide, and translates them to user-friendly messages.
  - `loadingInterceptor`: Shows and hides a global loading indicator during network traffic.
