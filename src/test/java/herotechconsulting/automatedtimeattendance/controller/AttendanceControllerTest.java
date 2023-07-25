package herotechconsulting.automatedtimeattendance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import herotechconsulting.automatedtimeattendance.models.Attendance;
import herotechconsulting.automatedtimeattendance.models.Employee;
import herotechconsulting.automatedtimeattendance.services.AttendanceService;
import herotechconsulting.automatedtimeattendance.services.AttendanceServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class AttendanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;
    String employeeId = "64c01b31a8a3333ab379c851";

    private Attendance attendance;

    @BeforeEach
    public void setUp() {
        attendance = new Attendance();
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Check In")
    public void test_addEmployee() throws Exception {
        attendance.setAction("Clock-in");
        attendance.setEmployeeId("64c01b31a8a3333ab379c851");

        this.mockMvc.perform(post("/attendances/clock-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(attendance)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

//    @Test
//    @DisplayName("Clock Out")
//    public void testClockOut() throws Exception {
//        Attendance mockedAttendance = new Attendance();
//        mockedAttendance.setEmployeeId(testEmployee.getId());
//        mockedAttendance.setAction("Clock-Out");
//
//        // Mock the behavior of the attendance service
//        when(attendanceService.clockOut(any(Employee.class))).thenReturn(mockedAttendance);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/attendances/clock-out")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(testEmployee)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(testEmployee.getId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.action").value("Clock-Out"));
//
//        // Verify that the attendance service method was called with the correct parameter
//        verify(attendanceService, times(1)).clockOut(eq(testEmployee));
//    }
//
//    @Test
//    @DisplayName("Start Break")
//    public void testStartBreak() throws Exception {
//        Attendance mockedAttendance = new Attendance();
//        mockedAttendance.setEmployeeId(testEmployee.getId());
//        mockedAttendance.setAction("Start-Break");
//
//        // Mock the behavior of the attendance service
//        when(attendanceService.startBreak(any(Employee.class))).thenReturn(mockedAttendance);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/attendances/start-break")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(testEmployee)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(testEmployee.getId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.action").value("Start-Break"));
//
//        // Verify that the attendance service method was called with the correct parameter
//        verify(attendanceService, times(1)).startBreak(eq(testEmployee));
//    }
//
//    @Test
//    @DisplayName("End Break")
//    public void testEndBreak() throws Exception {
//        Attendance mockedAttendance = new Attendance();
//        mockedAttendance.setEmployeeId(testEmployee.getId());
//        mockedAttendance.setAction("End-Break");
//
//        // Mock the behavior of the attendance service
//        when(attendanceService.endBreak(any(Employee.class))).thenReturn(mockedAttendance);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/attendances/end-break")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(testEmployee)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(testEmployee.getId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.action").value("End-Break"));
//
//        // Verify that the attendance service method was called with the correct parameter
//        verify(attendanceService, times(1)).endBreak(eq(testEmployee));
//    }

    // Additional tests for other endpoints and error scenarios can be added...

}