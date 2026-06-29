package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        EmployeeRepository repository = context.getBean(EmployeeRepository.class);

        LOGGER.info("HQL / Native / Aggregate Query Test");

        LOGGER.info("1. Get all permanent employees (Optimized Join Fetch):");
        List<Employee> permanent = repository.getAllPermanentEmployees();
        permanent.forEach(e -> {
            LOGGER.debug("Employee: {}, Skills: {}", e, e.getSkillList());
        });

        LOGGER.info("2. Department average salary:");
        try {
            double avgSalary = repository.getAverageSalary(1);
            LOGGER.debug("Average Salary for Dept 1 = {}", avgSalary);
        } catch (Exception ex) {
            LOGGER.error("Failed to compute average salary", ex);
        }

        LOGGER.info("3. Get all employees using Native SQL Query:");
        List<Employee> nativeEmployees = repository.getAllEmployeesNative();
        nativeEmployees.forEach(e -> LOGGER.debug("Native Employee: {}", e));
    }
}
