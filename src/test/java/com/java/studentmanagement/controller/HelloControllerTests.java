package com.java.studentmanagement.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.java.studentmanagement.controller.HelloController.GREETING_PATH;
import static com.java.studentmanagement.controller.HelloController.GREETING_RESPONSE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTests {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidResponseForGreeting() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(GREETING_PATH)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(GREETING_RESPONSE));
    }

    @Test
    public void testNotFoundResponseForInvalidPath() throws Exception
    {
        String invalidPath = "/some_dummy_path";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(invalidPath)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
