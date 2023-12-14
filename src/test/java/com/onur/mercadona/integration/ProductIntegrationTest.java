package com.onur.mercadona.integration;

import com.onur.mercadona.model.Product;
import com.onur.mercadona.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository.deleteAll();

        Product product1 = new Product();
        product1.setLabel("Product 1");
        product1.setPrice(10.0);

        Product product2 = new Product();
        product2.setLabel("Product 2");
        product2.setPrice(15.5);

        productRepository.save(product1);
        productRepository.save(product2);
    }

    @Test
    public void whenGetProducts_thenReturnsProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].label").value("Product 1"))
                .andExpect(jsonPath("$[1].label").value("Product 2"));
    }
}
