package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
@Table(name = "question")
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qt_id") private int id;
    @Column(name = "qt_text") private String text;
    public Question() {}
    public int getId() { return id; }
    public String getText() { return text; }
}
