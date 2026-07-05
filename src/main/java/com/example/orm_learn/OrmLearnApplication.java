package com.example.orm_learn;

import com.example.orm_learn.model.Stock;
import com.example.orm_learn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("----- Query 1 -----");
        List<Stock> fbStocks =
                stockRepository.findByCodeAndDateBetween(
                        "FB",
                        sdf.parse("2019-09-01"),
                        sdf.parse("2019-09-30"));

        fbStocks.forEach(System.out::println);

        System.out.println("----- Query 2 -----");
        List<Stock> googleStocks =
                stockRepository.findByCodeAndCloseGreaterThan(
                        "GOOGL",
                        1250);

        googleStocks.forEach(System.out::println);

        System.out.println("----- Query 3 -----");
        stockRepository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);

        System.out.println("----- Query 4 -----");
        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);
    }
}