package com.cognizant.ormlearn.model;
import javax.persistence.*;
import lombok.Data;
@Entity @Table(name="attempt_question") @Data
public class AttemptQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @ManyToOne @JoinColumn(name="attempt_id") private Attempt attempt;
    @ManyToOne @JoinColumn(name="question_id") private Question question;
}
