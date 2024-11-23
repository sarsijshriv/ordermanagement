package com.web.ordermanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="`product`")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String name;
    private String description;
    private Integer quantity;
    private Date manufacturing_date;
    private Date expiry_date;
    private Double price;
    private Instant created_at;
    private Instant updated_at;
}
