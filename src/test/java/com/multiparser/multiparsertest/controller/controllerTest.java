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

    private String expectedXls;
    private String expectedCsv;

    @Before
    public void setUp() throws Exception {
        this.expectedXls ="[{\"0\":\"01-06-2017\",\"1\":\"\",\"2\":\"\",\"3\":\"\",\"4\":\"PUBLIC HOLIDAY\",\"5\":\"\",\"6\":\"\",\"7\":\"\",\"8\":\"\"},{\"0\":\"02-06-2017\",\"1\":\"\",\"2\":\"\",\"3\":\"\",\"4\":\"TASK : TR Request PPD untuk upload data user (ASM) #960526\",\"5\":\"\",\"6\":\"\",\"7\":8.0,\"8\":1.0},{\"0\":\"03-06-2017\",\"1\":\"\",\"2\":\"\",\"3\":\"\",\"4\":\"Weekend\",\"5\":\"\",\"6\":\"\",\"7\":\"\",\"8\":\"\"},{\"0\":\"04-06-2017\",\"1\":\"\",\"2\":\"\",\"3\":\"\",\"4\":\"Weekend\",\"5\":\"\",\"6\":\"\",\"7\":\"\",\"8\":\"\"},{\"0\":\"05-06-2017\",\"1\":\"\",\"2\":\"\",\"3\":\"\",\"4\":\"TASK : TR Request PPD untuk upload data user (ASM) #960526\",\"5\":\"\",\"6\":\"\",\"7\":8.0,\"8\":1.0},{\"0\":\"06-06-2017\",\"1\":\"\",\"2\":\"\",\"3\":\"\",\"4\":\"Enterprise Division - Weekly Meeting \",\"5\":\"\",\"6\":\"\",\"7\":8.0,\"8\":1.0}]";
        this.expectedCsv = "[{\"name\":\"Billy\",\"age\":\"28\"},{\"name\":\"Barbara\",\"age\":\"36\"}]";
    }

    @Test
    public void file1() throws Exception {
        this.mockMvc.perform(get("/parseexcel/file1.xls/4/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(result -> result.equals(expectedXls));
    }

    @Test
    public void testCsv() throws Exception{
        this.mockMvc.perform(get("/parsecsv/test.csv"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(result -> result.equals(expectedCsv));
    }

}