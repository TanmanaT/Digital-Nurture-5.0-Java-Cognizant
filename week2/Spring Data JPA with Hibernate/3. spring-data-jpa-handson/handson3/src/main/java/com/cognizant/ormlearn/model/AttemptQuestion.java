package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
import java.util.Set;
@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id") private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aq_at_id") private Attempt attempt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aq_qt_id") private Question question;
    
    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.LAZY)
    private Set<AttemptOption> attemptOptions;
    
    public AttemptQuestion() {}
    public int getId() { return id; }
    public Attempt getAttempt() { return attempt; }
    public Question getQuestion() { return question; }
    public Set<AttemptOption> getAttemptOptions() { return attemptOptions; }
}
