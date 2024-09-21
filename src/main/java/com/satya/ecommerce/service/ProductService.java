package com.satya.ecommerce.service;

import com.satya.ecommerce.model.Product;
import com.satya.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product) throws IOException {

        if (repo.existsById(id)) {
            product.setId(id);
            return repo.save(product);
        }
        return null;
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
