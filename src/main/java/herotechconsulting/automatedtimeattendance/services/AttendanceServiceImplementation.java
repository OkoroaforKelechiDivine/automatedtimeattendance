package herotechconsulting.automatedtimeattendance.services;


import herotechconsulting.automatedtimeattendance.models.Attendance;
import herotechconsulting.automatedtimeattendance.models.Employee;
import herotechconsulting.automatedtimeattendance.repositories.AttendanceRepository;
import herotechconsulting.automatedtimeattendance.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AttendanceServiceImplementation implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

//    @Autowired
//    private EmployeeRepository em

    @Override
    public Attendance clockIn(Employee employee) {
        if (isClockedIn(employee)) {
            throw new IllegalStateException("Employee is already clocked in.");
        }
        employee.setClockedIn(true);

        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employee.getId());
        attendance.setAction("Clock-In");
        attendance.setTimestamp(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance clockOut(Employee employee) {
        if (!isClockedIn(employee)) {
            throw new IllegalStateException("Employee is not clocked in.");
        }
        employee.setClockedIn(false);

        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employee.getId());
        attendance.setAction("Clock-Out");
        attendance.setTimestamp(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance startBreak(Employee employee) {
        if (!isClockedIn(employee)) {
            throw new IllegalStateException("Employee is not clocked in.");
        }
        if (isOnBreak(employee)) {
            throw new IllegalStateException("Employee is already on a break.");
        }
        employee.setOnBreak(true);

        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employee.getId());
        attendance.setAction("Start-Break");
        attendance.setTimestamp(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance endBreak(Employee employee) {
        if (!isClockedIn(employee)) {
            throw new IllegalStateException("Employee is not clocked in.");
        }

        if (!isOnBreak(employee)) {
            throw new IllegalStateException("Employee is not on a break.");
        }
        employee.setOnBreak(false);

        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employee.getId());
        attendance.setAction("End-Break");
        attendance.setTimestamp(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    private boolean isClockedIn(Employee employee) {
        return employee.isClockedIn();
    }

    private boolean isOnBreak(Employee employee) {
        return employee.isOnBreak();
    }
}
