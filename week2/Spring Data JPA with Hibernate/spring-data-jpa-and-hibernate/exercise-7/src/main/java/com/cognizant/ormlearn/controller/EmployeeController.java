package com.cognizant.ormlearn.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired private EmployeeRepository repo;
    
    @GetMapping public List<Employee> getAll() { return repo.findAll(); }
    @PostMapping public Employee create(@RequestBody Employee emp) { return repo.save(emp); }
    @GetMapping("/{id}") public Employee get(@PathVariable int id) { return repo.findById(id).orElse(null); }
    @PutMapping("/{id}") public Employee update(@PathVariable int id, @RequestBody Employee emp) {
        emp.setId(id);
        return repo.save(emp);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable int id) { repo.deleteById(id); }
}
