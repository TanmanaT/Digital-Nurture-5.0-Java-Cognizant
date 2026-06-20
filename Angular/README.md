# Angular Student Course Portal - 10 Hands-On Exercises

Welcome to the Angular student course portal deepskilling workspace. This project showcases the complete step-by-step implementation of 10 practical Angular hands-on assignments.

---

## 🛠️ Tech Stack & Setup
- **Core Framework**: Angular 21 (Zoneless Change Detection mode)
- **Programming Language**: TypeScript
- **Styling**: Vanilla CSS (Premium Glassmorphic Dark UI Theme)
- **API Mocking**: `json-server` (Running on http://localhost:3000)
- **Testing Framework**: Jasmine & Karma

---

## 📂 Project Structures (Hands-On Directory Map)

1. **[hands_on_1](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_1)**: Base environment setup, Header, Home Dashboard, and Project structure analysis.
2. **[hands_on_2](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_2)**: Data binding methods (4 types), Lifecycle Hooks (`ngOnInit`, `ngOnChanges`, `ngOnDestroy`), and Parent-Child communication (`CourseCard` inputs/outputs).
3. **[hands_on_3](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_3)**: Structural directives (`*ngIf`, `*ngFor` with `trackBy`, `*ngSwitch`), attribute directives (`ngClass`, `ngStyle`), custom highlight directive, and custom credits labeling pipe.
4. **[hands_on_4](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_4)**: Template-Driven enrollment request form with dirty-state control styling and required field validations.
5. **[hands_on_5](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_5)**: Reactive Enrollment Form using `FormBuilder` with synchronous custom checks, async API mock checks (`simulateEmailCheck`), and dynamic course list arrays (`FormArray`).
6. **[hands_on_6](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_6)**: Singleton service providers (`CourseService` and `EnrollmentService`) and local scope validation using component-level Providers (`NotificationService`).
7. **[hands_on_7](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_7)**: Client-side routing, query filter parameter handlers, wildcard 404 screens, functional navigation guards (`authGuard`, `unsavedChangesGuard`), and lazy loaded enrollment feature modules.
8. **[hands_on_8](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_8)**: HTTP API Integration using `HttpClient`, RxJS operations (`retry`, `catchError`, `tap`), and functional HTTP interceptors (Authorization, Error handler, Loading spinner).
9. **[hands_on_9](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_9)**: Redux Store State Management using NgRx (`@ngrx/store`, `@ngrx/effects`, `@ngrx/entity`, DevTools).
10. **[hands_on_10](file:///d:/Digital-Nurture-5.0-Java-Cognizant/Angular/hands_on_10)**: Unit testing specs covering component rendering, bindings, Jasmine spies, HttpClient mock APIs, and NgRx store-connected components.

---

## 🚀 Execution Guide

### Step 1: Start the API server
Each hands-on directory (8, 9, 10) utilizes a mock database file. Execute:
```powershell
npx json-server --watch db.json --port 3000
```

### Step 2: Serve the Angular application
Navigate to the directory of the target hands-on (e.g., `hands_on_10`) and start the local development server:
```powershell
npm install
npm start
```
Open `http://localhost:4200` to interact with the portal!

### Step 3: Run Unit Tests (Hands-on 10)
To verify unit test coverage in `hands_on_10`, run:
```powershell
npx ng test --watch=false
```
