package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
@Table(name = "attempt_option")
public class AttemptOption {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id") private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ao_aq_id") private AttemptQuestion attemptQuestion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ao_op_id") private Options option;
    
    @Column(name = "ao_selected") private boolean selected;
    
    public AttemptOption() {}
    public int getId() { return id; }
    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public Options getOption() { return option; }
    public boolean isSelected() { return selected; }
}
