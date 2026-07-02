package com.cognizant.ormlearn.model;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.Set;

@Entity
@Table(name="department")
@Data
@ToString(exclude = "employeeList")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dp_id")
    private int id;
    
    @Column(name="dp_name")
    private String name;
    
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Employee> employeeList;
}
