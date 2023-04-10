package com.test.spring_boot_lesson.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "sales_period")
@NoArgsConstructor
@Getter
@Setter
public class SalesPeriodJpa {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sales_period_id_seq")
    @SequenceGenerator(name = "sales_period_id_seq", sequenceName = "sales_period_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "price")
    @Min(value = 0, message = "no be negative")
    private long price;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "product")
    @Min(value = 0, message = "no be negative")
    private Integer product;

    public SalesPeriodJpa( long price, Date dateFrom, Date dateTo, Integer product) {
        this.price = price;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.product = product;
    }

    @Override
    public String toString() {
        return "SalesPeriodJpa{" +
                "id=" + id +
                ", price=" + price +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getPrice() {
//        return price;
//    }
//
//    public void setPrice(long price) {
//        this.price = price;
//    }
//
//    public Date getDateFrom() {
//        return dateFrom;
//    }
//
//    public void setDateFrom(Date dateFrom) {
//        this.dateFrom = dateFrom;
//    }
//
//    public Date getDateTo() {
//        return dateTo;
//    }
//
//    public void setDateTo(Date dateTo) {
//        this.dateTo = dateTo;
//    }
}
