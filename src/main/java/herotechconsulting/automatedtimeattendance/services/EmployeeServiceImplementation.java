package herotechconsulting.automatedtimeattendance.services;

import herotechconsulting.automatedtimeattendance.exceptions.EmployeeExistException;
import herotechconsulting.automatedtimeattendance.models.Employee;
import herotechconsulting.automatedtimeattendance.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) throws EmployeeExistException {
        Employee existingEmployeeName = employeeRepository.findByName(employee.getName());
        if (existingEmployeeName != null) {
            throw new EmployeeExistException("An Employee with that name already exists");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) throws EmployeeExistException {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeExistException("Employee with ID: " + id + " couldn't be found in the system'"));
        // Check if the name is being changed and ensure it is not conflicting with another employee
        String newEmployeeName = employee.getName();
        if (!existingEmployee.getName().equals(newEmployeeName)) {
            Employee conflictingEmployee = employeeRepository.findByName(newEmployeeName);
            if (conflictingEmployee != null) {
                throw new EmployeeExistException("Another employee with that name already exists in the system");
            }
            existingEmployee.setName(newEmployeeName);
        }
        existingEmployee.setRole(employee.getRole());
        return employeeRepository.save(existingEmployee);
}
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
