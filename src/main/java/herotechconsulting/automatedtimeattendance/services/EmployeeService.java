package herotechconsulting.automatedtimeattendance.services;

import herotechconsulting.automatedtimeattendance.exceptions.EmployeeExistException;
import herotechconsulting.automatedtimeattendance.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee) throws EmployeeExistException;

    Employee updateEmployee(String id, Employee employee) throws EmployeeExistException;

    List<Employee> getAllEmployees();
}
