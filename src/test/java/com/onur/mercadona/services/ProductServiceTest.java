package com.onur.mercadona.services;

import com.onur.mercadona.dto.PromotionRequest;
import com.onur.mercadona.model.Product;
import com.onur.mercadona.repository.ProductRepository;
import com.onur.mercadona.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private PromotionRequest promotionRequest;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setLabel("Test Product");

        promotionRequest = new PromotionRequest();
    }

    @Test
    void whenCreateProduct_thenProductIsSaved() {
        Mockito.when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);
        Product created = productService.createProduct(product);
        Assertions.assertNotNull(created);
        assertEquals(product.getLabel(), created.getLabel());
    }

    @Test
    void whenFindAllProducts_thenListOfProductsIsReturned() {
        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));
        List<Product> products = productService.findAllProducts();
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
    }

    @Test
    void givenProductId_whenDeleteProduct_thenRepositoryMethodIsCalled() {
        Mockito.doNothing().when(productRepository).deleteById(ArgumentMatchers.anyLong());
        productService.deleteProduct(1L);
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void givenPromotionRequest_whenAddProductPromotion_thenPromotionIsAddedToProduct() {
        Mockito.when(productRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);
        Product updatedProduct = productService.addProductPromotion(1L, promotionRequest);
        Assertions.assertNotNull(updatedProduct);
        Assertions.assertEquals(promotionRequest.getStartDate(), updatedProduct.getPromotionStartDate());
    }
}
