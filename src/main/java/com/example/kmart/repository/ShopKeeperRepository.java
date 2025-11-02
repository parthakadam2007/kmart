package com.example.kmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.example.kmart.models.ShopKeeper;
import com.example.kmart.models.ShopKeeperDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopKeeperRepository extends JpaRepository<ShopKeeper, Long> {
    @Query(value = "SELECT * FROM shopkeepers WHERE email = :email", nativeQuery = true)
    ShopKeeper findByEmailNative(@Param("email") String email);
}
