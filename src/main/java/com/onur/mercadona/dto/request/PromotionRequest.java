package com.onur.mercadona.dto.request;

import com.onur.mercadona.model.Promotion;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PromotionRequest {



    @NotNull(message = "La date de début ne peut pas être nulle")
    private LocalDate startDate;

    @NotNull(message = "La date de fin ne peut pas être nulle")
    private LocalDate endDate;

    @Min(value = 0, message = "Le pourcentage de réduction ne peut pas être inférieur à 0")
    @Max(value = 100, message = "Le pourcentage de réduction ne peut pas être supérieur à 100")
    private Double discountPercentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name ;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Promotion toPromotion() {
        return new Promotion(this.getName(),"", this.getDiscountPercentage()); }

}
