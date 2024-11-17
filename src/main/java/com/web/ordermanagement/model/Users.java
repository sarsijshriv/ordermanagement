package com.web.ordermanagement.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;

import java.util.Date;

@Entity
@Table(name="customer")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String name;
    private String address;
    private Date date_of_birth;

    public Users() {
    }

    public Users(long user_id, String name, String address, Date date_of_birth) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.date_of_birth = date_of_birth;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
