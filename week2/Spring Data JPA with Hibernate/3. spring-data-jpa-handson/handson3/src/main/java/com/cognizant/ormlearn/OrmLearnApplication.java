package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.AttemptRepository;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        AttemptRepository repository = context.getBean(AttemptRepository.class);

        LOGGER.info("Quiz Attempt HQL Join Fetch Test");
        
        try {
            Attempt attempt = repository.getAttemptDetails(1, 1);
            if (attempt != null) {
                LOGGER.debug("Attempt User: {}", attempt.getUser().getName());
                LOGGER.debug("Attempt Date: {}", attempt.getDate());
                for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
                    LOGGER.debug("Question: {}", aq.getQuestion().getText());
                    for (AttemptOption ao : aq.getAttemptOptions()) {
                        LOGGER.debug("  Option: {} | Score: {} | Selected: {}", 
                            ao.getOption().getText(), ao.getOption().getScore(), ao.isSelected());
                    }
                }
            } else {
                LOGGER.warn("No attempt found for User 1, Attempt 1");
            }
        } catch (Exception ex) {
            LOGGER.error("Failed to run quiz query", ex);
        }
    }
}
