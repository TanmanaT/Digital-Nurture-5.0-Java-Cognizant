package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "attempt")
public class Attempt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id") private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "at_date") private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_us_id") private User user;
    
    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    private Set<AttemptQuestion> attemptQuestions;
    
    public Attempt() {}
    public int getId() { return id; }
    public Date getDate() { return date; }
    public User getUser() { return user; }
    public Set<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
}
