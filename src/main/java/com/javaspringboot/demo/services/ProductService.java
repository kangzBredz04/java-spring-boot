package com.javaspringboot.demo.services;

import java.util.List;
import java.util.Optional;

import com.javaspringboot.demo.models.Product;

public interface ProductService {
    // Tambah data produk
    String addProduct(Product product);

    // Tampil semua data produk
    List<Product> getAllProduct();

    // Update data produk by ID produk
    String updateProduct(Long id, Product product);

    // Hapus data produk by ID produk
    String deleteProduct(Long id);

    // Tampil data berdasarkan id
    Optional<Product> getProductById(Long id);

    // Tampil data produk secara ascending berdasarkan id
    List<Product> sortProductsByIdAscending();

    // Tampil data produk secara descending berdasarkan id
    List<Product> sortProductsByIdDescending();
}
