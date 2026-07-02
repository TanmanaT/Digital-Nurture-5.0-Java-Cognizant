package com.cognizant.ormlearn.model;
import javax.persistence.*;
import lombok.Data;
import java.util.List;
@Entity @Table(name="question") @Data
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String text;
    @OneToMany(mappedBy = "question") private List<Options> options;
}
