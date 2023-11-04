package com.onur.mercadona.services;


import com.onur.mercadona.model.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class productService {

    @Autowired
    private static com.onur.mercadona.repository.productRepository productRepository;
    public static product createProduct(product product) {

        return productRepository.save(product);
    }

    public static Optional<product> getProductBy(Long id) {

        return productRepository.findById(id);
    }

    public static product updateProduct(Long id, product updatedProduct) {

        return updatedProduct;
    }

//    public List<product> getAllProducts() {
//        return productRepository.findAll();
//    }
//    public product updateproduct(product product) {
//        if (productRepository.existsById(product.getId())) {
//            return productRepository.save(product);
//        }
//        return null;
//    }
    public static void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}



