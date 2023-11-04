package com.onur.mercadona.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String label;
    private String description;
    private double price;


    @Column(name = "image")
    private byte[] image;
    @ManyToOne
    private Category category;


    @Column(name = "promotion_start_date")
    private LocalDate promotionStartDate;
    @Column(name = "promotion_end_date")
    private LocalDate promotionEndDate;
    @Column(name = "promotion-percentage")
    private Double promotionPercentage;


    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//     Promotion G and S

    public LocalDate getPromotionStartDate() {
        return promotionStartDate;
    }

    public void setPromotionStartDate(LocalDate promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public LocalDate getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(LocalDate promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public Double getPromotionPercentage() {
        return promotionPercentage;
    }

    public void setPromotionPercentage(Double promotionPercentage) {
        this.promotionPercentage = promotionPercentage;
    }

}
