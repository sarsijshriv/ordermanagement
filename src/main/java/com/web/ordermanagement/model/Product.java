package com.web.ordermanagement.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long product_id;
    String name;
    String description;
    Integer quantity;
    Date manufacturing_date;
    Date expiry_date;
    Double price;
    Instant created_at;
    Instant updated_at;

    public Product() {
    }

    public Product(Long product_id, String name, String description, Integer quantity, Date manufacturing_date, Date expiry_date, Double price, Instant created_at, Instant updated_at) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.manufacturing_date = manufacturing_date;
        this.expiry_date = expiry_date;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getManufacturing_date() {
        return manufacturing_date;
    }

    public void setManufacturing_date(Date manufacturing_date) {
        this.manufacturing_date = manufacturing_date;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }
}
