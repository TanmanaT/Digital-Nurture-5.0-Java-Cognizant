# Hands-On 6: REST Service for Updating an Employee

## Objectives
* Implement `@PutMapping` to handle updates with full validation rules on complex objects (Employee -> Department -> Skills).

## Steps
1. Add validation rules to `Employee`, `Department`, and `Skill` properties.
2. In `EmployeeDao`, write `updateEmployee(Employee employee)` to modify list values. Throw `EmployeeNotFoundException` if no match is found.
3. Map a PUT endpoint to `/employees` in `EmployeeController` using `@PutMapping` and `@Valid`.
4. Handle parsing errors (e.g. invalid type fields) by overriding `handleHttpMessageNotReadable()` in `GlobalExceptionHandler`.
