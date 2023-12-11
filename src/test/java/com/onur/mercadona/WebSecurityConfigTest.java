package com.onur.mercadona;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onur.mercadona.dto.LoginRequest;
import com.onur.mercadona.dto.LoginResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WebSecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldAllowAccessToAllowedUrls() throws Exception {
        LoginRequest login = new LoginRequest();
        login.setUsername("Admin");
        login.setPassword("ezPv8iPTMSDpvlqFx+Tv5D4xDaOCl9eNbwGUj+Udr+s=");

        MvcResult token = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(login)))
                .andExpect(status().isOk())
                .andReturn();

        String jwToken = token.getResponse().getContentAsString();
        LoginResponse access = objectMapper.readValue(jwToken, LoginResponse.class);
        jwToken = access.getToken();

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
//    @Test
//    public void shouldRestrictAccessToProtectedUrls() throws Exception {
//        mockMvc.perform(get("/some/protected/url"))
//                .andExpect(status().isUnauthorized());
//    }
//}


