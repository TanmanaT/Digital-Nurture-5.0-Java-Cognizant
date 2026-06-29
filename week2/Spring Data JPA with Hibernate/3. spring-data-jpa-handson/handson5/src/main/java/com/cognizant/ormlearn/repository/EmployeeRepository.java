package com.cognizant.ormlearn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Handson 2: Optimized fetch join query to fetch permanent employees
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Handson 4: Aggregate query
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Handson 5: Native SQL query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
