package com.cognizant.ems.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cognizant.ems.model.Employee;
import com.cognizant.ems.projection.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Derived query method
    List<Employee> findByNameContaining(String name);

    // Custom query method
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findEmployeesByDeptName(@Param("deptName") String deptName);

    // Named query executor
    Employee findByEmail(String email);

    // Pagination query
    Page<Employee> findByNameContaining(String name, Pageable pageable);

    // Projection query
    List<EmployeeProjection> findProjectionByDepartmentId(Long deptId);
}
