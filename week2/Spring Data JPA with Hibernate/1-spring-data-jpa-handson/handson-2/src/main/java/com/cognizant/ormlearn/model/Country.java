package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @Column(name="code")
    private String code;
    
    @Column(name="name")
    private String name;
}
