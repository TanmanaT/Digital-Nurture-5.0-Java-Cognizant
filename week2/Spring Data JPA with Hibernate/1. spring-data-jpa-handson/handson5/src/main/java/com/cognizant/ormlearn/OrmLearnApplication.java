package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        LOGGER.info("Inside main");

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();

    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country IN={}", country);
        } catch (Exception e) {
            LOGGER.error("Error finding country", e);
        }
        
        try {
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Country ZZ={}", country);
        } catch (Exception e) {
            LOGGER.error("Country ZZ not found as expected: " + e.getMessage());
        }
        LOGGER.info("End testFindCountryByCode");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country("XY", "TestLand");
        countryService.addCountry(newCountry);
        try {
            Country country = countryService.findCountryByCode("XY");
            LOGGER.debug("Added Country={}", country);
        } catch (Exception e) {
            LOGGER.error("Failed to add", e);
        }
        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        countryService.updateCountry("XY", "TestLand Updated");
        try {
            Country country = countryService.findCountryByCode("XY");
            LOGGER.debug("Updated Country={}", country);
        } catch (Exception e) {
            LOGGER.error("Failed to update", e);
        }
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("XY");
        try {
            countryService.findCountryByCode("XY");
            LOGGER.error("Country XY should have been deleted!");
        } catch (Exception e) {
            LOGGER.debug("Country XY deleted successfully.");
        }
        LOGGER.info("End testDeleteCountry");
    }

}
