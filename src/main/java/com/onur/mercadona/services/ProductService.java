package com.onur.mercadona.services;


import com.onur.mercadona.dto.PromotionRequest;
import com.onur.mercadona.model.Product;

import com.onur.mercadona.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;


@Service
public class ProductService {

    @Autowired
    private static ProductRepository productRepository;
    public static Product createProduct(Product product) {

        return productRepository.save(product);
    }

    public static Optional<Product> getProductBy(Long id) {

        return productRepository.findById(id);
    }

    public static Product updateProduct(Long id, Product updatedProduct) {

        return updatedProduct;
    }
    //    }
//    public product updateProduct(product product) {
//        if (productRepository.existsById(product.getId())) {
//            return productRepository.save(product);
//        }
//        return null;
//    }

    public static List<Product> findAllProducts() {
        return productRepository.findAll();
    }


    //    public List<product> getAllProducts() {
//        return productRepository.findAll();

    public static void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

//    public static Product addProductPromotion(Long id, PromotionRequest promotionRequest) {
//        return new Product();
//    }


    public static Product addProductPromotion(Long id, PromotionRequest promotionRequest) {
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