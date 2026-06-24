# Exercise 3: Using Different Appenders

## Task
Write a Java application that demonstrates using different appenders with SL4J (e.g., logging to the Console and to a File simultaneously).

## Steps
1. Add SL4J API and Logback dependencies.
2. Create `logback.xml` in `src/main/resources/` (or directly loaded on the classpath) containing a ConsoleAppender and a FileAppender logging to `app.log`.
3. Create `AppendersExample.java` with a Logger writing log messages of various levels.
4. Execute to see console output and check that the messages are appended to `app.log`.

## Solution Files
- [`pom.xml`](./pom.xml): Maven project descriptor containing dependencies.
- [`src/main/resources/logback.xml`](./src/main/resources/logback.xml): Logback configuration defining console and file appenders.
- [`src/main/AppendersExample.java`](./src/main/AppendersExample.java): Java class writing log messages.
