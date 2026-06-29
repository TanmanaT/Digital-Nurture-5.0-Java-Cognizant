package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        StockRepository repository = context.getBean(StockRepository.class);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        LOGGER.info("Stock Queries Test");

        // FB Sept 2019
        LOGGER.info("1. Facebook stock in Sept 2019:");
        Date start = df.parse("2019-09-01");
        Date end = df.parse("2019-09-30");
        List<Stock> fbList = repository.findByCodeAndDateBetween("FB", start, end);
        fbList.forEach(s -> LOGGER.debug("FB stock: {}", s));

        // Google > 1250
        LOGGER.info("2. Google stock close > 1250:");
        List<Stock> googleList = repository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250.00"));
        googleList.forEach(s -> LOGGER.debug("Google stock: {}", s));

        // Top 3 highest volume
        LOGGER.info("3. Top 3 highest volume stocks:");
        List<Stock> highestVol = repository.findTop3ByOrderByVolumeDesc();
        highestVol.forEach(s -> LOGGER.debug("Top Volume stock: {}", s));

        // Lowest 3 Netflix close
        LOGGER.info("4. Lowest 3 close prices for Netflix:");
        List<Stock> lowestNflx = repository.findTop3ByCodeOrderByCloseAsc("NFLX");
        lowestNflx.forEach(s -> LOGGER.debug("Netflix Low stock: {}", s));
    }
}
