package com.example.kmart.services;
import com.example.kmart.models.ProductDTO;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Long id);
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}
