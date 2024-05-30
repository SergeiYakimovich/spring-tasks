package com.example;

import com.example.service.ProductService;
import org.springframework.modulith.Modulith;

@Modulith
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ProductService productService = new ProductService();
        System.out.println(productService.createProduct("test", "test", 1));
    }
}