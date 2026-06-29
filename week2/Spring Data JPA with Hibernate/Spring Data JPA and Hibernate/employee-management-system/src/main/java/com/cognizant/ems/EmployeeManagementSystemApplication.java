package com.cognizant.ems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import com.cognizant.ems.model.Department;
import com.cognizant.ems.model.Employee;
import com.cognizant.ems.repository.DepartmentRepository;
import com.cognizant.ems.repository.EmployeeRepository;
import java.util.ArrayList;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        return args -> {
            Department sales = new Department();
            sales.setName("Sales");
            sales = deptRepo.save(sales);

            Department engineering = new Department();
            engineering.setName("Engineering");
            engineering = deptRepo.save(engineering);

            Employee emp1 = new Employee();
            emp1.setName("Alice Smith");
            emp1.setEmail("alice@company.com");
            emp1.setDepartment(engineering);
            empRepo.save(emp1);

            Employee emp2 = new Employee();
            emp2.setName("Bob Jones");
            emp2.setEmail("bob@company.com");
            emp2.setDepartment(sales);
            empRepo.save(emp2);
        };
    }
}

