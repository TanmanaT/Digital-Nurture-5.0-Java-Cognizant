package com.cognizant.ormlearn.model;

import javax.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@Entity
@Table(name="employee")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String email;
    
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
}
