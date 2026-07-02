# Spring Data JPA with Hibernate Exercises

This folder contains the complete restructured exercises, hands-ons, and configurations for learning Spring Data JPA and Hibernate.

## Modules

1. **[Part 1: Spring Data JPA Hands-on](./1-spring-data-jpa-handson)**: Core ORM concepts, difference between JPA/Hibernate/Spring Data JPA, Country CRUD services, and basic entity mapping.
2. **[Part 2: Query Methods and Entity Relationships](./2-spring-data-jpa-handson)**: JPA Derived Query Methods (Country, Stocks) and Entity Relationships (`@ManyToOne`, `@OneToMany`, `@ManyToMany` with Employee, Department, Skill).
3. **[Part 3: JPQL, Native Queries, and Criteria Queries](./3-spring-data-jpa-handson)**: Advanced database querying via HQL/JPQL (e.g. Fetch Join optimizations), Aggregate Functions, Native SQL, and dynamic JPA Criteria Builder.
4. **[Part 4: Employee Management System](./spring-data-jpa-and-hibernate)**: Complete project exercises mapping, CRUD, custom queries, named queries, pagination, auditing, projections, multiple data sources, and batch processing.

## How to Run the Projects

### Running inside an IDE (VS Code / IntelliJ IDEA)
1. Open the specific exercise/hands-on folder (e.g., `1-spring-data-jpa-handson/handson-1`) in your IDE.
2. Locate the main Spring Boot class file: `src/main/java/com/cognizant/ormlearn/OrmLearnApplication.java`.
3. Right-click inside the file and click **Run** (or press `F5` / `Ctrl + F5`) to launch the application.

### Running via Command Line (using the local Maven tool)
Open your terminal, navigate to the specific exercise directory, and run it using the repository's embedded Maven wrapper:

```bash
# 1. Navigate to the project directory, e.g.:
cd "1-spring-data-jpa-handson/handson-1"

# 2. Run the Spring Boot application using the relative path to the embedded Maven wrapper:
../../../../.maven/apache-maven-3.9.6/bin/mvn.cmd spring-boot:run
```
