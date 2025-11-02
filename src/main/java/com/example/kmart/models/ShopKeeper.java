package com.example.kmart.models;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShopKeeper{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ShopKeeper_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_no;
    private String address;
}  