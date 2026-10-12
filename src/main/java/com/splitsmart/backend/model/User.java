package com.splitsmart.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity // This tells Spring/JPA that this class should represent a database table
@Table(name = "users")
public class User {

    @Id // This field is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PostgreSQL will automatically generate the ID when a new user is inserted
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150)
    private String email;

    public User(){ // This empty constructor is needed because when Hibernate reads a row from PostgreSQL it needs to create a Java user object first

    }
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
}