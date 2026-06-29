package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    
    @Query("SELECT distinct a FROM Attempt a " +
           "LEFT JOIN FETCH a.user u " +
           "LEFT JOIN FETCH a.attemptQuestions aq " +
           "LEFT JOIN FETCH aq.question q " +
           "LEFT JOIN FETCH aq.attemptOptions ao " +
           "LEFT JOIN FETCH ao.option o " +
           "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttemptDetails(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
