package com.cognizant.ormlearn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.model.Country;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        CountryRepository repo = context.getBean(CountryRepository.class);
        repo.save(new Country("IN", "India"));
        repo.save(new Country("ZA", "South Africa"));
        List<Country> res = repo.findByNameContaining("ou");
        System.out.println("Countries containing 'ou': " + res);
    }
}
