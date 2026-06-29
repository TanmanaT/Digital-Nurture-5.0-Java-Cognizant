package com.cognizant.ems.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.ems.model.Department;
import com.cognizant.ems.repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired private DepartmentRepository repository;

    @GetMapping
    public List<Department> getAll() { return repository.findAll(); }

    @PostMapping
    public Department create(@RequestBody Department d) { return repository.save(d); }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department details) {
        Department d = repository.findById(id).orElseThrow();
        d.setName(details.getName());
        return repository.save(d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
