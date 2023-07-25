package herotechconsulting.automatedtimeattendance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import herotechconsulting.automatedtimeattendance.models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;

    Employee employee;

    @BeforeEach
    public void startUpMethod() {
        objectMapper = new ObjectMapper();
        employee = new Employee();
    }

    @Test
    @DisplayName("Add employee")
    public void test_addEmployee() throws Exception {
        employee.setRole("Manage");
        employee.setName("zipDemon");

        this.mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();
    }

}