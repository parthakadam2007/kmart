package com.example.kmart.models;

public record CustomerDTO(Long customerId, String firstName, String lastName, String email, String phoneNo, String address) {
}
