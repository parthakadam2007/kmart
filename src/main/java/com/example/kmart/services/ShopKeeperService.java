package com.example.kmart.services;

import java.util.List;
import java.util.Optional;

import com.example.kmart.models.ShopKeeperDTO;

public interface ShopKeeperService {
    List<ShopKeeperDTO> getAllShopKeepers();
    Optional<ShopKeeperDTO> getShopKeeperById(Long ShopKeeper_id);
    ShopKeeperDTO getShopKeeperByEmail(String email);
    ShopKeeperDTO saveShopKeeper(ShopKeeperDTO ShopKeeperDTO);
    ShopKeeperDTO updateShopKeeper(Long id, ShopKeeperDTO ShopKeeperDTO);
    void deleteShopKeeper(Long ShopKeeper_id);
}


