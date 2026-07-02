package com.cognizant.ormlearn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.model.Stock;
import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        StockRepository repo = context.getBean(StockRepository.class);
        Stock s = new Stock();
        s.setCode("FB");
        s.setDate(new Date());
        s.setOpen(new BigDecimal("184.0"));
        s.setClose(new BigDecimal("190.0"));
        s.setVolume(1000000L);
        repo.save(s);
        System.out.println("Stocks greater than 150: " + repo.findByCodeAndCloseGreaterThan("FB", new BigDecimal("150")));
    }
}
