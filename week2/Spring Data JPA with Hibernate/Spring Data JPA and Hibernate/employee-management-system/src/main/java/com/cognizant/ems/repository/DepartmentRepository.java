package com.cognizant.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ems.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {}
