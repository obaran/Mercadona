package com.onur.mercadona.controller;


import com.onur.mercadona.model.Product;
import com.onur.mercadona.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.onur.mercadona.services.ProductService;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {

//        var p = new product();
//        p.setLabel("abc");

//        var j = this.productRepository.save(p);
     return ProductService.createProduct(product);
//        return j;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return ProductService.findAllProducts();
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
       return ProductService.updateProduct(id, updatedProduct);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        ProductService.deleteProduct(id);
    }

//    @PostMapping("/{id}/add-promotion")
//    public Product addProductPromotion(@PathVariable Long id, @RequestBody PromotionRequest promotionRequest) {
////        return productService.addProductPromotion(id, promotionRequest);
//        return new Product();
//    }

}


