package herotechconsulting.automatedtimeattendance.services;


import herotechconsulting.automatedtimeattendance.models.Attendance;
import herotechconsulting.automatedtimeattendance.models.Employee;

public interface AttendanceService {
    Attendance clockIn(Employee employeeClockIn);

    Attendance clockOut(Employee employeeClockOut);

    Attendance startBreak(Employee employeeStartBreak);

    Attendance endBreak(Employee employeeEndBreak);
}
