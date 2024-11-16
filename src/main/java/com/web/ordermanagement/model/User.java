package com.web.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class User {
    long user_id;
    String name;
    Date dateOfBirth;
    Date creationDate;
    
    @JsonIgnore
    Date lastUpdated;

}
