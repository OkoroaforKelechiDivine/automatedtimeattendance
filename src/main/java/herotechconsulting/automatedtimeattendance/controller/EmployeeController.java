package herotechconsulting.automatedtimeattendance.controller;


import herotechconsulting.automatedtimeattendance.exceptions.EmployeeExistException;
import herotechconsulting.automatedtimeattendance.models.Employee;
import herotechconsulting.automatedtimeattendance.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        try{
            Employee savedEmployee = employeeService.addEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }
        catch (EmployeeExistException employeeExistException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (NoSuchElementException noSuchElementException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (EmployeeExistException employeeExistException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
