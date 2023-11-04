package com.onur.mercadona.controller;


import com.onur.mercadona.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.onur.mercadona.services.productService;

import java.util.Optional;


@RestController
@RequestMapping("/products")
public class productController {

    @Autowired
    private com.onur.mercadona.repository.productRepository productRepository;

    @PostMapping
    public product createProduct(@RequestBody product product) {

//        var p = new product();
//        p.setLabel("abc");

//        var j = this.productRepository.save(p);
     return productService.createProduct(product);
//        return j;
    }
    @GetMapping("/{id}")
    public Optional<product> getProduct(@PathVariable Long id) {
        return productService.getProductBy(id);
    }

    @PutMapping("/{id}")
    public product updateProduct(@PathVariable Long id, @RequestBody product updatedProduct) {
       return productService.updateProduct(id, updatedProduct);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

//    @PostMapping("/{id}/add-promotion")
//    public Product addProductPromotion(@PathVariable Long id, @RequestBody PromotionRequest promotionRequest) {
////        return productService.addProductPromotion(id, promotionRequest);
//        return new Product();
//    }

}


