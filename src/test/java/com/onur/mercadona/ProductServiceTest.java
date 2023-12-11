package com.onur.mercadona;

import com.onur.mercadona.services.ProductService;
import com.onur.mercadona.dto.PromotionRequest;
import com.onur.mercadona.model.Product;
import com.onur.mercadona.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);

    }

    @Test
    void createProductTest() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.createProduct(product);

        assertNotNull(createdProduct);
        assertEquals(product.getId(), createdProduct.getId());
    }

    @Test
    void getProductByIdTest() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        Optional<Product> foundProduct = productService.getProductBy(1L);

        assertTrue(foundProduct.isPresent());
        assertEquals(product.getId(), foundProduct.get().getId());
    }

    @Test
    void updateProductTest() {
        Product updatedProduct = new Product();
        updatedProduct.setId(1L);


        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);

        Product result = productService.updateProduct(1L, updatedProduct);

        assertNotNull(result);
        assertEquals(updatedProduct.getId(), result.getId());

    }

    @Test
    void findAllProductsTest() {
        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));

        List<Product> products = productService.findAllProducts();

        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
    }

    @Test
    void deleteProductTest() {
        doNothing().when(productRepository).deleteById(anyLong());

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void addProductPromotionTest() {
        PromotionRequest promotionRequest = new PromotionRequest();

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.addProductPromotion(1L, promotionRequest);

        assertNotNull(result);

    }

}

