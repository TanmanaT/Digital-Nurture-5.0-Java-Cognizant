package com.cognizant.ems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import com.cognizant.ems.model.Employee;
import com.cognizant.ems.repository.EmployeeRepository;
import com.cognizant.ems.projection.EmployeeProjection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAll() { return repository.findAll(); }

    @PostMapping
    public Employee create(@RequestBody Employee e) { return repository.save(e); }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee details) {
        Employee e = repository.findById(id).orElseThrow();
        e.setName(details.getName());
        e.setEmail(details.getEmail());
        return repository.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }

    // Exercise 6: Pagination and Sorting
    @GetMapping("/search")
    public Page<Employee> search(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return repository.findByNameContaining(name, PageRequest.of(page, size, Sort.by(sortBy).ascending()));
    }

    // Exercise 8: Projection endpoints
    @GetMapping("/dept/{deptId}/projection")
    public List<EmployeeProjection> getProjections(@PathVariable Long deptId) {
        return repository.findProjectionByDepartmentId(deptId);
    }
}
