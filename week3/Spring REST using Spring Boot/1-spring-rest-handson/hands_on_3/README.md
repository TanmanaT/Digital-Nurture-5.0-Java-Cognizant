# Hands-On 3: Spring Core - Incorporate Logging

## Objectives
* Demonstrate inclusion of logging in a Spring Boot application using SLF4J and Logback
* Configure logging levels and patterns in `application.properties`

## Steps
1. Create `application.properties` in `src/main/resources` folder and add:
   ```properties
   logging.level.org.springframework=info
   logging.level.com.cognizant.springlearn=debug
   logging.pattern.console=%d{yyMMdd}|%d{HH:mm:ss.SSS}|%-20.20thread|%5p|%-25.25logger{25}|%25M|%m%n
   ```
2. In `SpringLearnApplication.java`, include imports and define a static logger:
   ```java
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;

   private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
   ```
3. Update `displayDate()` to use logging instead of `System.out.println()`:
   ```java
   public void displayDate() {
       LOGGER.info("START");
       ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
       SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
       try {
           Date date = format.parse("31/12/2018");
           LOGGER.debug(date.toString());
       } catch (ParseException e) {
           LOGGER.error("Error parsing date", e);
       }
       LOGGER.info("END");
   }
   ```
> [!IMPORTANT]
> Going forward, all methods should incorporate logging. Do not use `System.out.println()`.
