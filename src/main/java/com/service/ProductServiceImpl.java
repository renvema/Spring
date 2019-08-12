package com.service;

import com.dao.ProductDao;
import com.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> getProductsById(Long productId) {
        return productDao.getProductById(productId);
    }

    @Transactional
    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    @Transactional
    @Override
    public void update(Product product) {

        productDao.update(product);
    }
}
