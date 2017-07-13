package com.multiparser.multiparsertest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IT180517 on 7/11/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class controllerTest {
    @Autowired
    private MockMvc mockMvc;

    private String expectedResponse;

    @Before
    public void setUp() throws Exception {
        this.expectedResponse ="{\n" +
                "\"5\": {\n" +
                "\"0\": \"01-06-2017\",\n" +
                "\"4\": \"PUBLIC HOLIDAY\"\n" +
                "},\n" +
                "\"6\": {\n" +
                "\"0\": \"02-06-2017\",\n" +
                "\"4\": \"TASK : TR Request PPD untuk upload data user (ASM) #960526\",\n" +
                "\"7\": 8,\n" +
                "\"8\": 1\n" +
                "},\n" +
                "\"7\": {\n" +
                "\"0\": \"03-06-2017\",\n" +
                "\"4\": \"Weekend\"\n" +
                "},\n" +
                "\"8\": {\n" +
                "\"0\": \"04-06-2017\",\n" +
                "\"4\": \"Weekend\"\n" +
                "},\n" +
                "\"9\": {\n" +
                "\"0\": \"05-06-2017\",\n" +
                "\"4\": \"TASK : TR Request PPD untuk upload data user (ASM) #960526\",\n" +
                "\"7\": 8,\n" +
                "\"8\": 1\n" +
                "},\n" +
                "\"10\": {\n" +
                "\"0\": \"06-06-2017\",\n" +
                "\"4\": \"Enterprise Division - Weekly Meeting \",\n" +
                "\"7\": 8,\n" +
                "\"8\": 1\n" +
                "}\n" +
                "}";

    }

    @Test
    public void file1() throws Exception {
        this.mockMvc.perform(get("/parse/file1/4/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(result -> result.equals(expectedResponse));
    }

}