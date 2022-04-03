package com.josdem.swagger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josdem.swagger.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("it creates a new user")
    void shouldCreateUser(TestInfo testInfo) throws Exception {
        log.info("Running {}", testInfo.getDisplayName());
        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setName("josdem");
        user.setEmail("contact@josdem.io");
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user))).andExpect(status().isOk());
    }

    @Test
    @DisplayName("it gets all users")
    void shouldGetUsers(TestInfo testInfo) throws Exception {
        log.info("Running: {}", testInfo.getDisplayName());
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
