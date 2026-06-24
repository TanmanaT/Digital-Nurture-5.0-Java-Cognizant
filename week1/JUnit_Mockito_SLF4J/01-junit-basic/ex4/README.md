# Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in JUnit

## Scenario
You need to organize your tests using the Arrange-Act-Assert (AAA) pattern and use setup and teardown methods.

## Steps
1. Create a `BankAccount` class with `deposit`, `withdraw`, and `getBalance` methods.
2. Write a test class `BankAccountTest`.
3. Use `@Before` to initialize a new `BankAccount` instance before each test (Setup).
4. Use `@After` to clean up resources or state if needed (Teardown).
5. Apply the Arrange-Act-Assert (AAA) pattern in your tests.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor containing the JUnit 4 dependency.
- [`src/main/BankAccount.java`](./src/main/BankAccount.java): Domain class modeling a basic bank account.
- [`src/test/BankAccountTest.java`](./src/test/BankAccountTest.java): JUnit test class demonstrating AAA and life cycle annotations.
