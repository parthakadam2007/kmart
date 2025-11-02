package com.example.kmart.repository;
import com.example.kmart.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customers WHERE email = :email", nativeQuery = true)
    Customer findByEmailNative(String email);
}
