package com.example.restfulwebservice.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

class GreetingControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(GreetingController.class)
                            .build();
    }

    @Nested
    class GET_Greeting {

        @Test
        void shouldHaveResponseCode200Ok() throws Exception {

            mockMvc.perform(get("/greeting"))
                   .andExpect(status().isOk());
        }

        @Test
        void shouldHaveId() throws Exception {

            mockMvc.perform(get("/greeting"))
                   .andExpect(jsonPath("$.id").isNumber());
        }

        @Test
        void shouldHaveContent() throws Exception {

            mockMvc.perform(get("/greeting"))
                   .andExpect(jsonPath("$.content").value("Hello, World"));
        }

        @Test
        void shouldHaveContentCustomizedViaParam() throws Exception {

            mockMvc.perform(get("/greeting")
                    .param("name", "example-name"))
                   .andExpect(jsonPath("$.content").value("Hello, example-name"));
        }
    }
}