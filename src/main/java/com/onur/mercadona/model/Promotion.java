package com.onur.mercadona.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // nom de la promotion
    private String description; // description de la promotion
    private Double discount; // réduction en pourcentage

    public Promotion() {
    }

    public Promotion(String name, String description, Double discount) {
        this.name = name;
        this.description = description;
        this.discount = discount;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getDiscount() {
        return discount;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
