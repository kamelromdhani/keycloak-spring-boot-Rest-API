package com.example.productapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Container;

import com.example.productapp.service.ProductService;

import dasniko.testcontainers.keycloak.KeycloakContainer;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
	
	@MockBean
	ProductService productService;
	
	@Autowired
    private MockMvc mockMvc;

	@Container
	private KeycloakContainer keycloak = new KeycloakContainer()
	    .withRealmImportFile("classpath:realm-export.json");

    @Test
    public void whenUserIsGrantedWithAuthorizedRoleThenSecretMethodIsAccessible() throws Exception {
    	when(productService.getProducts()).thenReturn(Arrays.asList("Nissan","Mazda"));
    	this.mockMvc.perform(get("/products").header("Authorization","bearer X")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.ALL));
       
    }


}
