package com.test.spring_boot_lesson.service;

import com.test.spring_boot_lesson.models.SalesPeriodJdbc;
import com.test.spring_boot_lesson.models.SalesPeriodJpa;
import com.test.spring_boot_lesson.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private JdbcTemplate template;

    @Autowired
    private SalesRepository repository;

    @Override
    public int getCount() {
        System.out.println(repository.count());
        Integer count = template.queryForObject("select count(*) from db_example.sales_period", Integer.class);
        System.out.println(count);
        return (int) repository.count();
    }

    @Override
    public Optional<SalesPeriodJpa> getSaleById(int id) {
        Optional<SalesPeriodJpa> sale = repository.findById(id);
        System.out.println(sale.get());
        SalesPeriodJdbc salesPeriodJdbc = template.queryForObject(
                "select * from db_example.sales_period where id=" + id,
                SalesPeriodJdbc.class);
        System.out.println(salesPeriodJdbc);
        return sale;
    }

    @Override
    public void addSale(SalesPeriodJpa sale) {
        repository.save(sale);
        template.query("insert into db_example.sales_period", new RowMapper<SalesPeriodJpa>() {
            @Override
            public SalesPeriodJpa mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new SalesPeriodJpa(
                        rs.getLong("price"),
                        rs.getDate("sate_from"),
                        rs.getDate("date_to"),
                        rs.getInt("product")
                );
            }
        });
    }

    @Override
    public List<SalesPeriodJpa> getSalesPriceExceeds(long price) {
        List<SalesPeriodJpa> list = repository.findAllBySalesPriceExceeds100();
        for (SalesPeriodJpa item : list) System.out.println(item);
        List<SalesPeriodJpa> list1 = template.query("select * from db_example.sales_period",
                (rs, rowNum) -> new SalesPeriodJpa(
                        rs.getLong("price"),
                        rs.getDate("date_from"),
                        rs.getDate("date_to"),
                        rs.getInt("product")
                ));
        for (SalesPeriodJpa item : list1) System.out.println(item);
        return null;
    }

    @Override
    public List<SalesPeriodJpa> getSalesList() {
        List<SalesPeriodJpa> list = repository.findAll();
        return list;
    }
}
