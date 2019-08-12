package com.service;

import com.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getAll();

    Optional<Product> getProductsById(Long productId);

    void deleteProduct(Long id);

    void update(Product product);
}
