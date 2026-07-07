# Hands-On 4: Spring Core - Load Country from Configuration XML

## Objectives
* Demonstrate bean instantiation and injection using properties (`<property>`, setter injection)

## Steps
1. Create the `Country` class under `com.cognizant.springlearn`:
   * Properties: `code` (String), `name` (String)
   * Log `"Inside Country Constructor."` in the default constructor
   * Generate getters/setters and `toString()` with debug logs in setter/getters
2. Create `src/main/resources/country.xml`:
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
              https://www.springframework.org/schema/beans/spring-beans.xsd">

       <bean id="country" class="com.cognizant.springlearn.Country">
           <property name="code" value="IN" />
           <property name="name" value="India" />
       </bean>
   </beans>
   ```
3. Implement `displayCountry()` in `SpringLearnApplication.java`:
   ```java
   public void displayCountry() {
       ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
       Country country = context.getBean("country", Country.class);
       LOGGER.debug("Country : {}", country.toString());
   }
   ```
4. Invoke `displayCountry()` in `main()` and execute. Observe the console logs to see which constructors and methods are called.
