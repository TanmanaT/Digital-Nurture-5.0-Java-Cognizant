package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        CountryRepository repository = context.getBean(CountryRepository.class);

        LOGGER.info("Starting Query Method Tests");
        
        LOGGER.info("1. Countries containing 'ou':");
        List<Country> countries1 = repository.findByNameContaining("ou");
        countries1.forEach(c -> LOGGER.debug("Country: {}", c));

        LOGGER.info("2. Countries containing 'ou' sorted by Name Ascending:");
        List<Country> countries2 = repository.findByNameContainingOrderByNameAsc("ou");
        countries2.forEach(c -> LOGGER.debug("Country Asc: {}", c));

        LOGGER.info("3. Countries starting with 'Z':");
        List<Country> countries3 = repository.findByNameStartingWith("Z");
        countries3.forEach(c -> LOGGER.debug("Country 'Z': {}", c));
    }
}
