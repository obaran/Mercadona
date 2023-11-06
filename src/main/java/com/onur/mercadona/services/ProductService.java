package com.onur.mercadona.services;


import com.onur.mercadona.dto.PromotionRequest;
import com.onur.mercadona.model.Product;

import com.onur.mercadona.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public  Product createProduct(Product product) {

        return this.productRepository.save(product);
    }

    public  Optional<Product> getProductBy(Long id) {

        return this.productRepository.findById(id);
    }

    public  Product updateProduct(Long id, Product updatedProduct) {

        return updatedProduct;
    }
    //    }
//    public product updateProduct(product product) {
//        if (productRepository.existsById(product.getId())) {
//            return productRepository.save(product);
//        }
//        return null;
//    }

    public List<Product> findAllProducts() { return this.productRepository.findAll();
    }


    //    public List<product> getAllProducts() {
//        return productRepository.findAll();

    public  void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

//    public static Product addProductPromotion(Long id, PromotionRequest promotionRequest) {
//        return new Product();
//    }


    public  Product addProductPromotion(Long id, PromotionRequest promotionRequest) {
        // Retrieve the existing product
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product with id " + id + " not found");
        }
        Product product = productOptional.get();

        product.setPromotionStartDate(promotionRequest.getStartDate());
        product.setPromotionEndDate(promotionRequest.getEndDate());
        product.setPromotionPercentage(promotionRequest.getPromotionPercentage());
        return productRepository.save(product);
    }
}