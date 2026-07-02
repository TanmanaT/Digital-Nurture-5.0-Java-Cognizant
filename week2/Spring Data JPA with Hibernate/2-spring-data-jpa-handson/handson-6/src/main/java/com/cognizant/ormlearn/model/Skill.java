package com.cognizant.ormlearn.model;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.Set;

@Entity
@Table(name="skill")
@Data
@ToString(exclude = "employeeList")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sk_id")
    private int id;
    
    @Column(name="sk_name")
    private String name;
    
    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;
}
