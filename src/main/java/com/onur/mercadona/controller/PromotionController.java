package com.onur.mercadona.controller;

import com.onur.mercadona.services.PromotionService;
import com.onur.mercadona.model.Promotion;
import com.onur.mercadona.dto.request.PromotionRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping
    public ResponseEntity<Promotion> addPromotion(@RequestBody PromotionRequest promotionRequest) {
        Promotion promotion = promotionService.addPromotion(promotionRequest.toPromotion());
        return new ResponseEntity<>(promotion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotion(@PathVariable Long id) {
        Optional<Promotion> optionalPromotion = promotionService.getPromotionById(id);
        if (!optionalPromotion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalPromotion.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        List<Promotion> promotions = promotionService.getAllPromotions();
        if (promotions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

}
