package com.example.service;

import com.example.model.Product;

public class ProductService {
    public Product createProduct(String name, String description, int price) {
        return new Product(name, description, price);
    }
}
