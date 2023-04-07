package com.test.spring_boot_lesson.repositories;

import com.test.spring_boot_lesson.models.SalesPeriodJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SalesRepository extends JpaRepository<SalesPeriodJpa, Integer> {

    @Query(value = "select * from db_example.sales_period where price>100", nativeQuery = true)
    List<SalesPeriodJpa> findAllBySalesPriceExceeds100();
}
