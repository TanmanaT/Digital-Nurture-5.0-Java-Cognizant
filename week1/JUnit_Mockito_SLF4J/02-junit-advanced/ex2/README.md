# Exercise 2: Test Suites and Categories

## Scenario
You want to group related tests into a test suite and execute them together.

## Steps
1. Create two test classes `TestA` and `TestB` with dummy tests.
2. Create a test suite class `AllTests`.
3. Use JUnit 5's `@Suite` and `@SelectClasses` annotations to include `TestA` and `TestB` in the suite.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor containing the suite dependency `junit-platform-suite-engine`.
- [`src/test/TestA.java`](./src/test/TestA.java): First simple test class.
- [`src/test/TestB.java`](./src/test/TestB.java): Second simple test class.
- [`src/test/AllTests.java`](./src/test/AllTests.java): Suite class that groups `TestA` and `TestB`.
