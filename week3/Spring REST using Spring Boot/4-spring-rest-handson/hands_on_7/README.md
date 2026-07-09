# Hands-On 7: Implement REST DELETE Service

## Objectives
* Implement resource deletion using `@DeleteMapping`.

## Steps
1. Implement `deleteEmployee(int id)` in `EmployeeDao` and `EmployeeService`.
2. Add `@DeleteMapping("/employees/{id}")` in `EmployeeController`.
3. Throw `EmployeeNotFoundException` if the ID does not exist, and test using Postman/curl.
