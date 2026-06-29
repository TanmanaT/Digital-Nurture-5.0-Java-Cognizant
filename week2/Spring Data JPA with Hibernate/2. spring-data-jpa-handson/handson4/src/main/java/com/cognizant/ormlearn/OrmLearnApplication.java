package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.*;
import java.util.Date;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        SkillService skillService = context.getBean(SkillService.class);

        LOGGER.info("Starting Payroll Stage 4");

        try {
            Employee employee = employeeService.get(1);
            LOGGER.debug("Employee: {}", employee);
            LOGGER.debug("Department: {}", employee.getDepartment());
        } catch (Exception e) {
            LOGGER.error("Failed to load department mapping", e);
        }

    }
}
