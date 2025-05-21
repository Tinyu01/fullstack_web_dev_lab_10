package com.coffeeshop.menu.service;

import com.coffeeshop.menu.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    
    // Method to get product by ID for update operation
    Product getProductById(int id);
    
    // Method to delete product by ID
    void deleteProductById(int id);
}