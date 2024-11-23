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
    Long order_id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    Users users;
    OrderDeliveryStatus order_state;
    Double total_amount;
    Instant created_at;
}
