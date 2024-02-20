package com.javaspringboot.demo.models;

import lombok.*;

@Getter // Anotasi @Getter digunakan untuk menghasilkan metode getter untuk semua bidang
@Setter // Anotasi @Setter digunakan untuk menghasilkan metode setter untuk semua bidang
@Builder // Anotasi @Builder digunakan untuk menghasilkan builder pattern untuk kelas
@NoArgsConstructor // Anotasi @NoArgsConstructor digunakan untuk menghasilkan sebuah constructor
                   // tanpa parameter (default constructor).
@AllArgsConstructor // Anotasi @AllArgsConstructor digunakan untuk menghasilkan sebuah constructor
                    // dengan parameter yang sesuai dengan semua bidang (fields) yang dimiliki oleh
                    // kelas
public class Product {
    private Long id;
    private String name;
    private String description;
    private Long price;
}
