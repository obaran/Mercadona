package com.onur.mercadona.controller;


import com.onur.mercadona.dto.PromotionRequest;
import com.onur.mercadona.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.onur.mercadona.services.ProductService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return this.productService.createProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        var products = this.productService.findAllProducts();

        if (products == null){
            return new ArrayList<>();
        }
        return products;
    }
    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        return this.productService.updateProduct(updatedProduct);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }

    @PostMapping("/{id}/add-promotion")
    public Product addProductPromotion(@PathVariable Long id, @RequestBody PromotionRequest promotionRequest) {
        return this.productService.addProductPromotion(id, promotionRequest);
    }

}


