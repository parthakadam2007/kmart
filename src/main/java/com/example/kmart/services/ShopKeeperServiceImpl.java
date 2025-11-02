package com.example.kmart.services;

import com.example.kmart.models.ShopKeeper;
import com.example.kmart.models.ShopKeeperDTO;
import com.example.kmart.repository.ShopKeeperRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopKeeperServiceImpl implements ShopKeeperService {

    private final ShopKeeperRepository ShopKeeperRepository;

    public ShopKeeperServiceImpl(ShopKeeperRepository ShopKeeperRepository) {
        this.ShopKeeperRepository = ShopKeeperRepository;
    }

    @Override
    public List<ShopKeeperDTO> getAllShopKeepers() {
        return ShopKeeperRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ShopKeeperDTO> getShopKeeperById(Long id) {
        return ShopKeeperRepository.findById(id).map(this::convertToDTO);
    }

    // private ShopKeeperDTO convertToDTO(ShopKeeper shopKeeper) {
    //     // Implementation logic to map fields
    //     ShopKeeperDTO dto = new ShopKeeperDTO();
    //     dto.setId(shopKeeper.getId());
    //     dto.setName(shopKeeper.getName());
    //     // set other fields...
    //     return dto;
    // }

    @Override
    public ShopKeeperDTO getShopKeeperByEmail(String email) {
        ShopKeeper shopKeeper = ShopKeeperRepository.findByEmailNative(email);
        if (shopKeeper == null) {
            return null; // or throw an exception
        }
        return convertToDTO(shopKeeper);
    }


    @Override
    public ShopKeeperDTO saveShopKeeper(ShopKeeperDTO ShopKeeperDTO) {
        ShopKeeper ShopKeeper = convertToEntity(ShopKeeperDTO);
        ShopKeeper savedShopKeeper = ShopKeeperRepository.save(ShopKeeper);
        return convertToDTO(savedShopKeeper);
    }

    // @Override
    // public ShopKeeperDTO updateShopKeeper(Long id, ShopKeeperDTO ShopKeeperDTO) {
    //     ShopKeeper ShopKeeper = ShopKeeperRepository.findById(id).orElseThrow();
    //     ShopKeeper.setName(ShopKeeperDTO.name());
    //     ShopKeeper.setDescription(ShopKeeperDTO.description());
    //     ShopKeeper.setPrice(ShopKeeperDTO.price());
    //     ShopKeeper updatedShopKeeper = ShopKeeperRepository.save(ShopKeeper);
    //     return convertToDTO(updatedShopKeeper);
    // }

@Override
public ShopKeeperDTO updateShopKeeper(Long shopkeeperId, ShopKeeperDTO shopKeeperDTO) {
    ShopKeeper shopKeeper = ShopKeeperRepository.findById(shopkeeperId)
            .orElseThrow(() -> new RuntimeException("ShopKeeper not found with ID: " + shopkeeperId));

    shopKeeper.setFirstName(shopKeeperDTO.firstName());
    shopKeeper.setLastName(shopKeeperDTO.lastName());
    shopKeeper.setEmail(shopKeeperDTO.email());
    shopKeeper.setPhoneNo(shopKeeperDTO.phoneNo());
    shopKeeper.setAddress(shopKeeperDTO.address());

    ShopKeeper updatedShopKeeper = ShopKeeperRepository.save(shopKeeper);
    return convertToDTO(updatedShopKeeper);
}


    @Override
    public void deleteShopKeeper(Long id) {
        ShopKeeperRepository.deleteById(id);
    }

    // Convert ShopKeeper Entity to ShopKeeperDTO
    private ShopKeeperDTO convertToDTO(ShopKeeper ShopKeeper) {
        return new ShopKeeperDTO(ShopKeeper.getShopKeeperId(), ShopKeeper.getFirstName(), ShopKeeper.getLastName(), ShopKeeper.getEmail(),ShopKeeper.getPhoneNo(),ShopKeeper.getAddress());
    }

    // Convert ShopKeeperDTO to ShopKeeper Entity
    private ShopKeeper convertToEntity(ShopKeeperDTO ShopKeeperDTO) {
        ShopKeeper ShopKeeper = new ShopKeeper();
        ShopKeeper.setFirstName(ShopKeeperDTO.firstName());
        ShopKeeper.setLastName(ShopKeeperDTO.lastName());
        ShopKeeper.setEmail(ShopKeeperDTO.email());
        ShopKeeper.setPhoneNo(ShopKeeperDTO.phoneNo());
        ShopKeeper.setAddress(ShopKeeperDTO.address());
        return ShopKeeper;
    }
}