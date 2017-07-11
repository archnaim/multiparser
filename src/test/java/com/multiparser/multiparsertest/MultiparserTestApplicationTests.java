package com.multiparser.multiparsertest;

import com.multiparser.multiparsertest.controller.controller;
import com.multiparser.multiparsertest.service.ReadExcel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controller.class)
public class MultiparserTestApplicationTests {
    @MockBean
    private ReadExcel readExcel;

    @Autowired
    private MockMvc mockMvc;
    private String mockResult;

    @Before
    public void setUp()
    {
        when(readExcel.parse("file1")).thenCallRealMethod();
        mockResult =
                "[\n" +
                        "{\n" +
                        "\"date\": \"01-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"PUBLIC HOLIDAY\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"02-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"TASK : TR Request PPD untuk upload data user (ASM) #960526\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"03-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Weekend\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"04-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Weekend\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"05-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"TASK : TR Request PPD untuk upload data user (ASM) #960526\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"06-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Enterprise Division - Weekly Meeting \",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"07-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Parameter APP Configuration (TR #957149)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"08-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Parameter APP Configuration (TR #957149)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"09-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Parameter APP Configuration (TR #957149)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"10-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Weekend\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"11-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Weekend\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"12-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Parameter APP Configuration (TR #957149)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"13-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Enterprise Division - Weekly Meeting \",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"14-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Parameter APP Configuration (TR #957149)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"15-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Parameter APP Configuration (TR #957149)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"16-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Explore - Enterprise payroll (BTPN Payment)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"17-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Weekend\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"18-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Weekend\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"19-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Explore - Enterprise payroll (BTPN Payment)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"20-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Explore - Enterprise payroll (BTPN Payment)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"21-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Explore - Enterprise payroll (BTPN Payment)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"22-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Explore - Enterprise payroll (BTPN Payment)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"23-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Mitrais Self-Learning (Jakarta Based Office)\",\n" +
                        "\"hours\": \"8.0\",\n" +
                        "\"days\": \"1.0\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"24-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Weekend\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"25-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Public Holiday\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"26-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Public Holiday\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"27-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Leave\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"28-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Leave\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"29-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Leave\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": \"30-06-2017\",\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": \"Leave\",\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": null,\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": null,\n" +
                        "\"hours\": null,\n" +
                        "\"days\": null\n" +
                        "},\n" +
                        "{\n" +
                        "\"date\": null,\n" +
                        "\"ref1\": null,\n" +
                        "\"ref2\": null,\n" +
                        "\"project_task\": null,\n" +
                        "\"hours\": \":\",\n" +
                        "\"days\": \"16.0\"\n" +
                        "}\n" +
                        "]";
    }
	@Test
	public void getFile1Test() throws Exception {
        this.mockMvc.perform(get("/file1"))
                .andExpect(status().isOk())
//                .andExpect(content().json(mockResult))
//                .andExpect(content().string(Matchers.containsString("TASK : TR Request PPD untuk upload data user (ASM) #960526")))
                .andDo(result -> result.equals(mockResult));
    }

}
