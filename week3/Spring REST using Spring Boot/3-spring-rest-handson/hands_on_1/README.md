# Hands-On 1: Create Static Employee List Data using Spring XML Config

## Objectives
* Define Domain model beans, Collections, and DAO setup in XML config.

## Steps
1. Add `employee.xml` under `src/main/resources` containing Department, Skills, and Employee list:
   * Create standard model classes: `Employee`, `Department`, `Skill`.
   * Configure them in `employee.xml` using constructor injection and collections:
     ```xml
     <bean id="hr" class="com.cognizant.springlearn.Department">
         <property name="id" value="1" />
         <property name="name" value="HR" />
     </bean>
     ```
2. Create `com.cognizant.springlearn.dao.EmployeeDao` class:
   * Maintain a static variable `EMPLOYEE_LIST` of type `ArrayList<Employee>`.
   * Read the list from `employee.xml` using `ClassPathXmlApplicationContext` in the constructor.
   * Provide `getAllEmployees()` returning the static list.
