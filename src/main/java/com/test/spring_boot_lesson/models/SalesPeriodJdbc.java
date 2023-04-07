package com.test.spring_boot_lesson.models;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SalesPeriodJdbc {
    private long id;
    private long price;
    private Date dateFrom;
    private Date dateTo;
    private Integer product;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SalesPeriodJdbc{" +
                "id=" + id +
                ", price=" + price +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", product=" + product +
                '}';
    }

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
//
//    public Integer getProduct() {
//        return product;
//    }
//
//    public void setProduct(Integer product) {
//        this.product = product;
//    }
}
