package com.riccskn.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class ProductModel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public ProductModel(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    private String name;

    private BigDecimal price;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
