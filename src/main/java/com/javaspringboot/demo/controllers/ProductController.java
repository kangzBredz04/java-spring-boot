package com.javaspringboot.demo.controllers;

import java.util.List;

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
    public List<Product> allProduct() {
        return productService.getAllProduct();
    }

    // Controller update data produk berdasarkan id produk
    @PutMapping("/update-product/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // Controller delete data produk berdasarkan id produk
    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deletProduct(id);
    }
}
