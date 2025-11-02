package com.example.kmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kmart.models.ShopKeeper;

public interface ShopKeeperRepository extends JpaRepository<ShopKeeper, Long> {

    @Query(value = "SELECT * FROM shopkeepers WHERE email = :email", nativeQuery = true)
    ShopKeeper findByEmailNative(@Param("email") String email);
}
