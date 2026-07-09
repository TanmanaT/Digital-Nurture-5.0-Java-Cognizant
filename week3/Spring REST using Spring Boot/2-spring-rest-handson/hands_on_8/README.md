# Hands-On 8: MockMvc - Test Get Country Exceptional Scenario

## Objectives
* Test error responses and exceptions with `MockMvc`.

## Steps
1. Add a test case `testGetCountryException()` in `SpringLearnApplicationTests.java` that makes a call to a non-existent code like `/countries/az`:
   ```java
   @Test
   public void testGetCountryException() throws Exception {
       ResultActions actions = mvc.perform(get("/countries/az"));
       actions.andExpect(status().isNotFound());
       actions.andExpect(status().reason("Country not found"));
   }
   ```
