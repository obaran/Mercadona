package com.onur.mercadona.controller;


import com.onur.mercadona.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class productController {

    @Autowired
    private com.onur.mercadona.repository.productRepository productRepository;

    @PostMapping
    public product createProduct(@RequestBody product product) {

        var p = new product();
        p.setLabel("abc");

        var j = this.productRepository.save(p);
//        return productService.createProduct(product);
        return j;
    }

//    @PostMapping("/{id}/add-promotion")
//    public Product addProductPromotion(@PathVariable Long id, @RequestBody PromotionRequest promotionRequest) {
////        return productService.addProductPromotion(id, promotionRequest);
//        return new Product();
//    }

}


