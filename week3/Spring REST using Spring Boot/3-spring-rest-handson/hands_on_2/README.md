# Hands-On 2: Create REST Service to Get All Employees

## Objectives
* Implement the Service layer with `@Service` annotation and Controller layer for Employees.

## Steps
1. Create `com.cognizant.springlearn.service.EmployeeService`:
   * Use `@Service` annotation.
   * Autowire `EmployeeDao` and provide `getAllEmployees()`.
2. Create `com.cognizant.springlearn.controller.EmployeeController`:
   * Annotate with `@RestController`.
   * Map GET request to `/employees` to return `employeeService.getAllEmployees()`.
3. Test using Postman.
