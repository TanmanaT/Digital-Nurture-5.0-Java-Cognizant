package com.cognizant.ormlearn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.ormlearn.model.Employee;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContaining(String name);
}
