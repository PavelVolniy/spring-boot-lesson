package com.test.spring_boot_lesson.controllers;

import com.test.spring_boot_lesson.models.SalesPeriodJpa;
import com.test.spring_boot_lesson.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;


@Controller/*("/TechIndustry")*/
public class MyController {
    @Autowired
    private SalesService service;

    @GetMapping("/")
    public String getName(@RequestParam(name = "name", required = false, defaultValue = "not name") String name,
                          Model model) {
        model.addAttribute("nameManager", name);
        return "start-view";
    }

    @RequestMapping("/showListSales")
    public String showListSales(@Valid @ModelAttribute("SalesPeriodJpa") SalesPeriodJpa sale, Model model
            , BindingResult result) {
        List<SalesPeriodJpa> list = service.getSalesList();
        model.addAttribute("salesList", list);
        for (SalesPeriodJpa item: list) System.out.println(item);
        if (result.hasErrors()) return "start-view";
        else return "sale-list-view";
    }
}
