package com.test.spring_boot_lesson.controllers;

import com.test.spring_boot_lesson.models.SalesPeriodJpa;
import com.test.spring_boot_lesson.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller/*("/TechIndustry")*/
public class MyController {
    @Autowired
    private SalesService service;

    @GetMapping("/")
    public String getName() {
        return "start-view";
    }

    @PostMapping("/")
    public String enter(@RequestParam(name = "name", required = false, defaultValue = "No name") String name, Model model) {
        model.addAttribute("name", name);
        return "/showListSales";
    }

    @GetMapping("/showListSales")
    public String showListSales(Model model) {
        Iterable<SalesPeriodJpa> list = service.getSalesList();
        model.addAttribute("salesList", list);
        for (SalesPeriodJpa item : list) System.out.println(item);
        return "sale-list-view";
    }

    @PostMapping("/showListSales")
    public String addSale(@RequestParam Integer price, @RequestParam Date dateFrom, @RequestParam Date dateTo, @RequestParam Integer product){
        service.addSale(new SalesPeriodJpa(price, dateFrom, dateTo, product));
        return "/showListSales";
    }
}
