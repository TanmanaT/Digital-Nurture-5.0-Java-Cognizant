# Hands-On 4: REST - Get All Countries

## Objectives
* Retrieve a list of beans from XML config and return it as a JSON Array.

## Steps
1. Add a method in `CountryController`:
   ```java
   @GetMapping("/countries")
   public List<Country> getAllCountries() {
       LOGGER.info("START getAllCountries");
       ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
       List<Country> list = context.getBean("countryList", ArrayList.class);
       LOGGER.info("END getAllCountries");
       return list;
   }
   ```
2. Test using Postman or browser at `http://localhost:8083/countries`.
