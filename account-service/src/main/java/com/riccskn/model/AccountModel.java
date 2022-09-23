package com.riccskn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "accounts")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;

    private String name;

    private String password;

    private String email;

    public AccountModel() {

    }
    public AccountModel(String username,String name,String password,String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
    }



}
