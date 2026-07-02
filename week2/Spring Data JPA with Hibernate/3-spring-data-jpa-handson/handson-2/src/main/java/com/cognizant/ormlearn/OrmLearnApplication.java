package com.cognizant.ormlearn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Department;
import java.util.Date;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        EmployeeService empService = context.getBean(EmployeeService.class);
        DepartmentService deptService = context.getBean(DepartmentService.class);

        Department dept = new Department();
        dept.setName("Admin");
        deptService.save(dept);

        Employee emp = new Employee();
        emp.setName("Jane Doe");
        emp.setSalary(60000);
        emp.setPermanent(true);
        emp.setDateOfBirth(new Date());
        emp.setDepartment(dept);
        empService.save(emp);

        System.out.println("Permanent Employees HQL: " + empService.getAllPermanentEmployees());
        System.out.println("Average Salary: " + empService.getAverageSalary(1));
    }
}
