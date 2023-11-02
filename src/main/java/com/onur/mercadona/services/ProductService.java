package com.onur.mercadona.services;

import com.onur.mercadona.model.Product;
import com.onur.mercadona.dto.request.PromotionRequest;
import com.onur.mercadona.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product addProductPromotion(Long id, PromotionRequest promotionRequest) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setStartDate(promotionRequest.getStartDate());
            product.setEndDate(promotionRequest.getEndDate());
            product.setDiscountPercentage(promotionRequest.getDiscountPercentage());
            return productRepository.save(product);
        }
        return null;
    }
}

