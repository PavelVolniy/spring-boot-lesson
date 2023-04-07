package com.test.spring_boot_lesson.service;


import com.test.spring_boot_lesson.models.SalesPeriodJpa;

import java.util.List;
import java.util.Optional;

public interface SalesService {

    int getCount();

    Optional<SalesPeriodJpa> getSaleById(int id);

    void addSale(SalesPeriodJpa sale);

    List<SalesPeriodJpa> getSalesPriceExceeds(long price);

    List<SalesPeriodJpa> getSalesList();
}
