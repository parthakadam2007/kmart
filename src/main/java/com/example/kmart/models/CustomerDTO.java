package com.example.kmart.models;

public record CustomerDTO(Long customerId, String first_name, String last_name, String email, String phoneNo, String address) {
}
