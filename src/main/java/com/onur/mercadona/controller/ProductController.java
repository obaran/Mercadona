package com.onur.mercadona.controller;

import com.onur.mercadona.Service.ProductService;
import com.onur.mercadona.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;




@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}/promotion")
    public Product putProductInPromotion(@PathVariable Long id, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam double discountPercentage) {
        return productService.putProductInPromotion(id, startDate, endDate, discountPercentage);
    }

}


