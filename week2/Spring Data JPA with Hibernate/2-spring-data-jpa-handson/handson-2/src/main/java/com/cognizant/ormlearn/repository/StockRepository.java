package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Stock;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCodeAndDateBetween(String code, Date start, Date end);
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);
    List<Stock> findTop3ByOrderByVolumeDesc();
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
