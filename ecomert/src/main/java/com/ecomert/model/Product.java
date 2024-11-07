package com.ecomert.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private double price;
    private double stock;
    private String description;

    private String image;        // Tên file
    private String imagePath;    // Đường dẫn đầy đủ

    @Transient
    private MultipartFile imageFile;
}
