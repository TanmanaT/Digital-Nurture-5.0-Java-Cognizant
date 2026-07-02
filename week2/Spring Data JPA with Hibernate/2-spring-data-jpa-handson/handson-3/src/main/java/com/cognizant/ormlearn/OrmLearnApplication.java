package com.cognizant.ormlearn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Skill;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        EmployeeService empService = context.getBean(EmployeeService.class);
        DepartmentService deptService = context.getBean(DepartmentService.class);
        SkillService skillService = context.getBean(SkillService.class);

        Department dept = new Department();
        dept.setName("IT");
        deptService.save(dept);

        Skill skill = new Skill();
        skill.setName("Java");
        skillService.save(skill);

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setSalary(50000);
        emp.setPermanent(true);
        emp.setDateOfBirth(new Date());
        emp.setDepartment(dept);
        emp.setSkillList(new HashSet<>());
        emp.getSkillList().add(skill);
        empService.save(emp);

        System.out.println("Fetched Employee: " + empService.get(1));
    }
}
