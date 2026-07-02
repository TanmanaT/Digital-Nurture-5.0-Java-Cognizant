package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        // Seed database
        countryService.addCountry(new Country("IN", "India"));
        countryService.addCountry(new Country("US", "United States of America"));
        countryService.addCountry(new Country("ZA", "South Africa"));

        LOGGER.info("Inside main");
        
        LOGGER.info("Start test CRUD actions");
        // Add Country
        Country newCountry = new Country("FR", "France");
        countryService.addCountry(newCountry);
        LOGGER.debug("Added: {}", countryService.findCountryByCode("FR"));

        // Update Country
        countryService.updateCountry("FR", "French Republic");
        LOGGER.debug("Updated: {}", countryService.findCountryByCode("FR"));

        // Delete Country
        countryService.deleteCountry("FR");
        try {
            countryService.findCountryByCode("FR");
        } catch(Exception e) {
            LOGGER.debug("Deleted successfully (Not Found thrown)");
        }
        LOGGER.info("End test CRUD actions");
    
    }
}
