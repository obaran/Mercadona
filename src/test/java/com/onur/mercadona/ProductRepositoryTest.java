package com.onur.mercadona;

import com.onur.mercadona.model.Product;
import com.onur.mercadona.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenSaved_thenFindsById() {
        Product product = new Product();
        product.setLabel("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(9.99);
        // Configurez les autres propriétés si nécessaire

        product = productRepository.save(product);

        Optional<Product> foundProduct = productRepository.findById(product.getId());
        assertTrue(foundProduct.isPresent());
        assertEquals(product.getLabel(), foundProduct.get().getLabel());
        assertEquals(product.getPrice(), foundProduct.get().getPrice());
    }

    @Test
    public void whenFindAll_thenReturnsAllProducts() {
        Product product1 = new Product();
        product1.setLabel("Product 1");
        product1.setPrice(10.0);
        // Configurez les autres propriétés de product1 si nécessaire

        Product product2 = new Product();
        product2.setLabel("Product 2");
        product2.setPrice(15.5);
        // Configurez les autres propriétés de product2 si nécessaire

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> products = productRepository.findAll();

        assertFalse(products.isEmpty());
        assertEquals(2, products.size());
    }

    @Test
    public void whenInvalidId_thenProductNotFound() {
        Optional<Product> foundProduct = productRepository.findById(-99L);
        assertFalse(foundProduct.isPresent());
    }

    @Test
    public void whenDelete_thenRemoved() {
        Product product = new Product();
        product.setLabel("Product for Delete");
        product.setPrice(20.0);
        // Configurez les autres propriétés si nécessaire

        product = productRepository.save(product);

        productRepository.deleteById(product.getId());

        Optional<Product> foundProduct = productRepository.findById(product.getId());
        assertFalse(foundProduct.isPresent());
    }

    // Ajoutez ici d'autres tests selon vos besoins
}


