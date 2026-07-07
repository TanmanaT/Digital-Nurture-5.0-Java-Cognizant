# Hands-On 1: Create a Spring Boot Application

## Objectives
* Demonstrate creation of Spring Boot Application using Spring Initializr (https://start.spring.io)
* Understand `@SpringBootApplication` and `SpringApplication.run()`
* Explore standard project folder layout:
  * `src/main/java` - Folder with application source code
  * `src/main/resources` - Folder for application configuration
  * `src/test/java` - Folder with code for testing the application
  * `pom.xml` - Project object model containing dependencies

## Steps
1. Go to **https://start.spring.io/**
2. Set **Group** as `"com.cognizant"` and **Artifact** as `"spring-learn"`
3. Select **Spring Boot DevTools** and **Spring Web** dependencies
4. Generate the project as a zip file and extract it
5. Build the project using Maven command:
   ```bash
   mvn clean package
   ```
6. Verify if the `main()` method of `SpringLearnApplication.java` has logs and run the application.
