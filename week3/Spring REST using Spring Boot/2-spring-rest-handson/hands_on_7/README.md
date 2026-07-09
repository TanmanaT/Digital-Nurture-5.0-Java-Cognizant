# Hands-On 7: MockMvc - Test Get Country Service

## Objectives
* Implement unit/integration testing for controllers using `MockMvc`

## Steps
1. Autowire `CountryController` and test if context loads:
   ```java
   @Autowired
   private CountryController countryController;

   @Test
   public void contextLoads() {
       assertNotNull(countryController);
   }
   ```
2. Annotate the test class with `@AutoConfigureMockMvc` and autowire `MockMvc`:
   ```java
   @Autowired
   private MockMvc mvc;
   ```
3. Write a test method checking if `/country` returns status 200 and matches expected JSON keys:
   ```java
   @Test
   public void testGetCountry() throws Exception {
       ResultActions actions = mvc.perform(get("/country"));
       actions.andExpect(status().isOk());
       actions.andExpect(jsonPath("$.code").exists());
       actions.andExpect(jsonPath("$.code").value("IN"));
       actions.andExpect(jsonPath("$.name").value("India"));
   }
   ```
