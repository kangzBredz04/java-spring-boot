package com.javaspringboot.demo.services;

import java.util.List;

import com.javaspringboot.demo.models.Product;

public interface ProductService {
    // Tambah data produk
    String addProduct(Product product);

    // Tampil semua data produk
    List<Product> getAllProduct();
}
