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
    Long product_id;
    String name;
    String description;
    Integer quantity;
    Date manufacturing_date;
    Date expiry_date;
    Double price;
    Instant created_at;
    Instant updated_at;
}
