# Booklet 6: Mocking Dependencies in Spring Tests using Mockito

This booklet demonstrates different context levels and annotation patterns for mocking dependencies inside Spring tests.

## Exercises

1. **[Exercise 1: Mocking a Service Dependency in a Controller Test](./ex1)**: Using `@MockBean` inside a `@WebMvcTest` controller test to isolate web tier controller logic from the business logic service tier.
2. **[Exercise 2: Mocking a Repository in a Service Test](./ex2)**: Standard Mockito extension unit test demonstrating service testing while mocking repository database layer operations.
3. **[Exercise 3: Mocking a Service Dependency in an Integration Test](./ex3)**: Using `@MockBean` in combination with `@SpringBootTest` and `@AutoConfigureMockMvc` for testing controllers with a partially mocked application context.
