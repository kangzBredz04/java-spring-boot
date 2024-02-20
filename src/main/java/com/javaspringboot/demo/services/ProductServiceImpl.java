package com.javaspringboot.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaspringboot.demo.models.Product;

@Service
public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList<>();

    @Override
    public String addProduct(Product product) {
        // Cara 1 tambah produk
        // products.add(product);

        // Cara 2 tambah produk menggunakan lamda
        products.add(Product.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build());
        return "Successfully add product";
    }

    @Override
    public List<Product> getAllProduct() {
        // cara 1 tampil data produk
        return products;
    }

    @Override
    public String updateProduct(Long id, Product product) {
        for (Product pr : products) {
            if (pr.getId() == id) {
                pr.setName(product.getName());
                pr.setDescription(product.getDescription());
                pr.setPrice(product.getPrice());
                return "Product updated successfully!";
            }
        }
        return "Product with ID " + id + " not found!";
    }

    @Override
    public String deletProduct(Long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return "Product deleted successfully!";
            }
        }
        return "Product with ID " + id + " not found!";
    }

}
