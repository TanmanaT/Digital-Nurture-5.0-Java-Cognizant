package com.cognizant.ormlearn.model;
import javax.persistence.*;
import lombok.Data;
@Entity @Table(name="options") @Data
public class Options {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String text;
    private double score;
    @ManyToOne @JoinColumn(name="question_id") private Question question;
}
