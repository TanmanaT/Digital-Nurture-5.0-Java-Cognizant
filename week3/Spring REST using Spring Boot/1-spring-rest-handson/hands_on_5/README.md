# Hands-On 5: Singleton and Prototype Scopes

## Objectives
* Demonstrate differences between `singleton` (default) and `prototype` scopes in Spring

## Steps
1. **Singleton Scope (Default):**
   * Fetch the `country` bean twice in `displayCountry()`:
     ```java
     Country country = context.getBean("country", Country.class);
     Country anotherCountry = context.getBean("country", Country.class);
     ```
   * Run the application and verify that the Country constructor is called **only once**, indicating the same instance is shared.
2. **Prototype Scope:**
   * Modify the bean definition in `country.xml` to include `scope="prototype"`:
     ```xml
     <bean id="country" class="com.cognizant.springlearn.Country" scope="prototype">
     ```
   * Run the application and verify that the Country constructor is called **twice**, showing two separate instances were created.
