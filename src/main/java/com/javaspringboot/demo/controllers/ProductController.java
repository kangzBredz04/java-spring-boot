package com.javaspringboot.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.demo.models.Product;
import com.javaspringboot.demo.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    // Controller tambah data produk
    @PostMapping("/add-product")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Controller tampil data produk secara keseluruhan
    @GetMapping("/all-product")
    public List<?> allProduct() {
        List<Product> products = productService.getAllProduct();
        if (products.isEmpty()) {
            // Jika data kosong, kembalikan ArrayList berisi pesan "Data belum ada"
            List<String> message = new ArrayList<>();
            message.add("Data belum ada");
            return message;
        }
        return products;
    }

    // Controller update data produk berdasarkan id produk
    @PutMapping("/update-product/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // Controller delete data produk berdasarkan id produk
    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    // Controller tampil data produk berdasarkan id produk
    @GetMapping("/get-product/{id}")
    public Object getMethodName(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            return "Product with ID " + id + " not found !!!";
        }
    }

    // Controller tampil data produk secara ascending berdasarkan id
    @GetMapping("/sort-by-id-ascending")
    public List<Product> sortProductsByIdAscending() {
        return productService.sortProductsByIdAscending();
    }

    // Controller tampil data produk secara descending berdasarkan id
    @GetMapping("/sort-by-id-descending")
    public List<Product> sortProductsByIdDescending() {
        return productService.sortProductsByIdDescending();
    }
}
