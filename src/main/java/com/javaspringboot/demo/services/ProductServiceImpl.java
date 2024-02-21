package com.javaspringboot.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // Cara 1 update data arraylist
        // for (Product pr : products) {
        // if (pr.getId() == id) {
        // pr.setName(product.getName());
        // pr.setDescription(product.getDescription());
        // pr.setPrice(product.getPrice());
        // return "Product updated successfully!";
        // }
        // }
        // return "Product with ID " + id + " not found!";

        // Cara 2 update data arraylist menggunakan sintak lambda
        products.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .ifPresent(p -> {
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    p.setPrice(product.getPrice());
                });
        return "Successfully update from list";
    }

    @Override
    public String deleteProduct(Long id) {
        // Cara 1 hapus data arraylist
        // for (Product product : products) {
        // if (product.getId() == id) {
        // products.remove(product);
        // return "Product deleted successfully!";
        // }
        // }
        // return "Product with ID " + id + " not found!";

        // Cara 2 hapus data arraylist menggunakan lambda
        // products.stream()
        // .filter(product -> product.getId() == id)
        // .findAny()
        // .ifPresent(product -> products.remove(product));

        // return "Successfully remove from list";

        // Cara 3 hapus data arraylist menggunakan lambda
        Optional<Product> productToDelete = products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();

        if (productToDelete.isPresent()) {
            products.remove(productToDelete.get());
            return "Product with ID " + id + " deleted successfully!";
        } else {
            return "Data dengan id " + id + " tidak ada";
        }
    }

}
