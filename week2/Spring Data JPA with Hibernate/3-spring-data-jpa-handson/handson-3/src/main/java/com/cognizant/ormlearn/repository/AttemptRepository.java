package com.cognizant.ormlearn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cognizant.ormlearn.model.Attempt;
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    @Query("SELECT a FROM Attempt a left join fetch a.attemptQuestions aq left join fetch aq.question q WHERE a.user.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
