package com.cognizant.ormlearn.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired private EmployeeRepository employeeRepository;
    @Transactional(readOnly = true) public List<Employee> getAllPermanentEmployees() { return employeeRepository.getAllPermanentEmployees(); }
    @Transactional(readOnly = true) public double getAverageSalary(int deptId) { return employeeRepository.getAverageSalary(deptId); }
    @Transactional public void save(Employee emp) { employeeRepository.save(emp); }
}
