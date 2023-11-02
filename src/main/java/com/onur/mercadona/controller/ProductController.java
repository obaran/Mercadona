package com.onur.mercadona.controller;

import com.onur.mercadona.services.ProductService;
import com.onur.mercadona.model.Product;
import com.onur.mercadona.dto.request.PromotionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//commentaire pour le test commit ssh
@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/{id}/add-promotion")
    public Product addProductPromotion(@PathVariable Long id, @RequestBody PromotionRequest promotionRequest) {
        return productService.addProductPromotion(id, promotionRequest);
    }

}


