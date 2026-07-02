package com.cognizant.ormlearn.model;

import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name="department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    @OneToMany(mappedBy="department")
    private List<Employee> employees;
}
