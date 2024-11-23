package com.web.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name="`user`")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String name;
    private String email;
    private String password;
    private String address;
    private Date date_of_birth;
    private Instant created_at;
    private Instant updated_at;
}
