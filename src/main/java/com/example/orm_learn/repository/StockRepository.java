package com.example.orm_learn.repository;

import com.example.orm_learn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Facebook stocks in a date range
    List<Stock> findByCodeAndDateBetween(
            String code,
            Date startDate,
            Date endDate);

    // Google stocks where close price > value
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            double close);

    // Top 3 highest volumes
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Lowest 3 Netflix closing prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(
            String code);
}