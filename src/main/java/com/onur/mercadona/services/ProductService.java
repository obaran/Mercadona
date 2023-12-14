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


    public Product createProduct(Product product) {

        return this.productRepository.save(product);
    }

    public Product updateProduct(Product updatedProduct) {

        return updatedProduct;
    }

    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    public Product addProductPromotion(Long id, PromotionRequest promotionRequest) {
        // Retrieve the existing product
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product with id " + id + " not found");
        }
        Product product = productOptional.get();

        product.setPromotionStartDate(promotionRequest.getStartDate());
        product.setPromotionEndDate(promotionRequest.getEndDate());
        product.setPromotionPercentage(promotionRequest.getPromotionPercentage());
        return productRepository.save(product);
    }
}