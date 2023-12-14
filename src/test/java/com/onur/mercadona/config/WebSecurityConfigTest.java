package com.onur.mercadona.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onur.mercadona.dto.LoginRequest;
import com.onur.mercadona.model.Admin;
import com.onur.mercadona.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WebSecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void shouldAllowAccessToAllowedUrls() throws Exception {
        LoginRequest login = new LoginRequest();
        login.setUsername("Admin");
        login.setPassword("TestPassword");

        adminRepository.save(new Admin("Admin", bCryptPasswordEncoder.encode("TestPassword")));

        MvcResult token = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(login)))
                .andExpect(status().isOk())
                .andReturn();

        String jwToken = token.getResponse().getContentAsString();

        mockMvc.perform(get("/products")
                        .header("Authorization", "Bearer " + jwToken))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


