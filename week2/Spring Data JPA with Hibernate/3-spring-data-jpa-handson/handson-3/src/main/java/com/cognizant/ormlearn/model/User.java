package com.cognizant.ormlearn.model;
import javax.persistence.*;
import lombok.Data;
@Entity @Table(name="user") @Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String name;
}
