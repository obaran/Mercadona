package com.onur.mercadona.dto;

import java.time.LocalDate;
public class PromotionRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private Double promotionPercentage;

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

    public Double getPromotionPercentage() {
        return promotionPercentage;
    }

    public void setPromotionPercentage(Double promotionPercentage) {
        this.promotionPercentage = promotionPercentage;
    }

}
