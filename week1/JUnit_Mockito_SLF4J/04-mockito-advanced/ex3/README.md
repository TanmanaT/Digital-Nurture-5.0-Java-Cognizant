# Exercise 3: Mocking File I/O

## Scenario
You need to test a service that reads from and writes to files.

## Steps
1. Create mock interfaces `FileReader` and `FileWriter` using Mockito.
2. Stub reader methods to simulate file reading (return a string) and writer methods to do nothing or simulate output.
3. Write a test to verify the service logic (`processFile()`) using the mocked reader and writer.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor with JUnit Jupiter and Mockito Core.
- [`src/main/FileReader.java`](./src/main/FileReader.java): File Reader interface.
- [`src/main/FileWriter.java`](./src/main/FileWriter.java): File Writer interface.
- [`src/main/FileService.java`](./src/main/FileService.java): Service performing file operations.
- [`src/test/FileServiceTest.java`](./src/test/FileServiceTest.java): JUnit 5 test class demonstrating File I/O mocking.
