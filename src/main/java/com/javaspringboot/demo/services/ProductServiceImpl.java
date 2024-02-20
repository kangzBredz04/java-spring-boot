package com.javaspringboot.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.javaspringboot.demo.models.Product;

public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList<>();

    @Override
    public String addProduct(Product product) {
        products.add(product);
        return "Successfully add product";
    }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

}
