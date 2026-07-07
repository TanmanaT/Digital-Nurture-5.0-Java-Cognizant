# Hands-On 2: Load SimpleDateFormat from Spring Configuration XML

## Objectives
* Demonstrate loading a bean from Spring Configuration XML (`ClassPathXmlApplicationContext`, `context.getBean()`)
* Use Constructor Injection to initialize a class (`<constructor-arg>`)

## Steps
1. Create a Spring configuration file named `date-format.xml` in `src/main/resources` folder:
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
              https://www.springframework.org/schema/beans/spring-beans.xsd">
       
       <bean id="dateFormat" class="java.text.SimpleDateFormat">
           <constructor-arg value="dd/MM/yyyy" />
       </bean>
   </beans>
   ```
2. Create a new method `displayDate()` in `SpringLearnApplication.java`:
   ```java
   public void displayDate() {
       ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
       SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
       try {
           Date date = format.parse("31/12/2018");
           System.out.println(date);
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }
   ```
3. Run the application and check the console output.
