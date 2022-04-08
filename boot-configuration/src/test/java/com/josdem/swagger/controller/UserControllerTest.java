package com.josdem.swagger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josdem.swagger.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.matchesRegex;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    private static final String UUID_REGEX = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    private static final UUID USER_UUID = UUID.randomUUID();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @DisplayName("it creates a new user")
    void shouldCreateUser(TestInfo testInfo) throws Exception {
        log.info("Running {}", testInfo.getDisplayName());
        User user = new User();
        user.setUuid(USER_UUID);
        user.setName("josdem");
        user.setEmail("contact@josdem.io");

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid", matchesRegex(UUID_REGEX)))
                .andExpect(jsonPath("$.name").value("josdem"))
                .andExpect(jsonPath("$.email").value("contact@josdem.io"));
    }

    @Test
    @Order(2)
    @DisplayName("it gets user by uuid")
    void shouldGetUserByUuid(TestInfo testInfo) throws Exception {
        log.info("Running: {}", testInfo.getDisplayName());
        mockMvc.perform(get("/users/" + USER_UUID).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid", matchesRegex(UUID_REGEX)))
                .andExpect(jsonPath("$.name").value("josdem"))
                .andExpect(jsonPath("$.email").value("contact@josdem.io"));
    }

    @Test
    @Order(3)
    @DisplayName("it gets all users")
    void shouldGetUsers(TestInfo testInfo) throws Exception {
        log.info("Running: {}", testInfo.getDisplayName());
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)));
    }

}
