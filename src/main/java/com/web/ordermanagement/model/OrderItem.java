package com.web.ordermanagement.model;

import com.web.ordermanagement.misc.OrderItemDeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_item_id;
    private String productName;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable=false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private OrderItemDeliveryStatus orderItemDeliveryStatus;
    private Instant created_at;
    private Instant updated_at;
}
