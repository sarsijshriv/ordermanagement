package com.web.ordermanagement.model;

import com.web.ordermanagement.misc.OrderDeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name="`order`")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
    private OrderDeliveryStatus order_state;
    private Double total_amount;
    private Instant created_at;
    private Instant updated_at;
}
