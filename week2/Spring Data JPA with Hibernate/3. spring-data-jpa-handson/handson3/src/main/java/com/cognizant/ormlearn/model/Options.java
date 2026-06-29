package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
@Table(name = "options")
public class Options {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id") private int id;
    @Column(name = "op_text") private String text;
    @Column(name = "op_score") private double score;
    public Options() {}
    public int getId() { return id; }
    public String getText() { return text; }
    public double getScore() { return score; }
}
