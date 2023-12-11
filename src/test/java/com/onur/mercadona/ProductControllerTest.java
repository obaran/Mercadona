package com.onur.mercadona;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onur.mercadona.controller.ProductController;
import com.onur.mercadona.dto.PromotionRequest;
import com.onur.mercadona.model.Product;
import com.onur.mercadona.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = standaloneSetup(productController).build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateProduct() throws Exception {
        Product product = new Product(); // Set properties of product as required
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(product)));

        verify(productService, times(1)).createProduct(any(Product.class));
    }

    @Test
    public void testGetAllProducts() throws Exception {
        List<Product> productList = Arrays.asList(new Product(), new Product()); // Create test products
        when(productService.findAllProducts()).thenReturn(productList);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productList)));

        verify(productService, times(1)).findAllProducts();
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Long productId = 1L;
        Product updatedProduct = new Product(); // Set properties of updated product
        when(productService.updateProduct(eq(productId), any(Product.class))).thenReturn(updatedProduct);

        mockMvc.perform(put("/products/" + productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedProduct)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedProduct)));

        verify(productService, times(1)).updateProduct(eq(productId), any(Product.class));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Long productId = 1L;
        doNothing().when(productService).deleteProduct(productId);

        mockMvc.perform(delete("/products/" + productId))
                .andExpect(status().isOk());

        verify(productService, times(1)).deleteProduct(productId);
    }

    @Test
    public void testAddProductPromotion() throws Exception {
        Long productId = 1L;
        PromotionRequest promotionRequest = new PromotionRequest(); // Set properties of promotion request
        Product productWithPromotion = new Product(); // Set properties of product with promotion
        when(productService.addProductPromotion(eq(productId), any(PromotionRequest.class))).thenReturn(productWithPromotion);

        mockMvc.perform(post("/products/" + productId + "/add-promotion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productWithPromotion)));

        verify(productService, times(1)).addProductPromotion(eq(productId), any(PromotionRequest.class));
    }
}
