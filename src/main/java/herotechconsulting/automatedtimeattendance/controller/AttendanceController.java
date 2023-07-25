package herotechconsulting.automatedtimeattendance.controller;


import herotechconsulting.automatedtimeattendance.models.Attendance;
import herotechconsulting.automatedtimeattendance.models.Employee;
import herotechconsulting.automatedtimeattendance.services.AttendanceService;
import herotechconsulting.automatedtimeattendance.services.AttendanceServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceServiceImplementation attendanceService;


    @PostMapping("/clock-in")
    public ResponseEntity<Attendance> clockIn(@RequestBody Employee employee) {
        try {
            Attendance attendance = attendanceService.clockIn(employee);
            return ResponseEntity.ok(attendance);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/clock-out")
    public ResponseEntity<Attendance> clockOut(@RequestBody Employee employee) {
        try {
            Attendance attendance = attendanceService.clockOut(employee);
            return ResponseEntity.ok(attendance);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // or return an error message if needed
        }
    }

    @PostMapping("/start-break")
    public ResponseEntity<Attendance> startBreak(@RequestBody Employee employee) {
        try {
            Attendance attendance = attendanceService.startBreak(employee);
            return ResponseEntity.ok(attendance);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/end-break")
    public ResponseEntity<Attendance> endBreak(@RequestBody Employee employee) {
        try {
            Attendance attendance = attendanceService.endBreak(employee);
            return ResponseEntity.ok(attendance);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
