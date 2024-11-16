package com.web.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@EntityScan
public class User {
    long user_id;
    String name;
    String address;
    Date dateOfBirth;
    @JsonIgnore
    Date creationDate;
    @JsonIgnore
    Date lastUpdated;
}
