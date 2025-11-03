package com.example.kmart.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kmart.services.ShopKeeperService;
import com.example.kmart.models.ShopKeeperDTO;


// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import java.util.Optional;

@RestController
@RequestMapping("/api/shopkeepers")
public class ShopKeeperController {
    private final ShopKeeperService shopKeeperService;

    public ShopKeeperController(ShopKeeperService shopKeeperService) {
        this.shopKeeperService = shopKeeperService;
    }

    @GetMapping
    public List<ShopKeeperDTO> getAllShopKeepers() {
        return shopKeeperService.getAllShopKeepers();
    }

    @GetMapping("/{id}")
    public ShopKeeperDTO getShopKeeperById(@PathVariable Long id) {
        return shopKeeperService.getShopKeeperById(id).orElse(null);
    }
    @GetMapping("/email/{email}")
    public ShopKeeperDTO getShopKeeperByEmail(@PathVariable String email) {
        return shopKeeperService.getShopKeeperByEmail(email);
    }
    @PostMapping
    public ShopKeeperDTO createShopKeeper(@RequestBody ShopKeeperDTO shopKeeperDTO) {
        return shopKeeperService.saveShopKeeper(shopKeeperDTO);
    }
    @PutMapping("/{id}")
    public ShopKeeperDTO updateShopKeeper(@PathVariable Long id, @RequestBody ShopKeeperDTO shopKeeperDTO) {
        return shopKeeperService.updateShopKeeper(id, shopKeeperDTO);
    }
    
}
