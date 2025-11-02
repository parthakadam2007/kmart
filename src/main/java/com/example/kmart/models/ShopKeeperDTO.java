package com.example.kmart.models;

public record ShopKeeperDTO(
    Long ShopKeeper_id,
    String first_name,
     String last_name,
     String email,
     String phone_no,
     String address 
    ){
}
