package com.cognizant.ormlearn.model;
import javax.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
@Entity @Table(name="attempt") @Data
public class Attempt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private Date date;
    @ManyToOne @JoinColumn(name="user_id") private User user;
    @OneToMany(mappedBy="attempt") private List<AttemptQuestion> attemptQuestions;
}
