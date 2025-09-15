// CONTROLLER: Employee

package org.nikadisplay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import org.nikadisplay.Model.Employee;
import org.nikadisplay.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees") // BASE PATH ---> Currently localhost:8080/api/employees
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired // Constructor injection --> we are using EmployeeService since it contains our data and main business logic
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<?> addNewEmployee(@RequestParam String newName, @RequestParam int newSalary) {

            List<Employee> tryAddNewEmployee = employeeService.addEmployee(newName, newSalary);

            if (tryAddNewEmployee != null) {
                return new ResponseEntity<>(tryAddNewEmployee, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Employee list is currently at max capacity of 20! To add a new employee, you must delete one first.", HttpStatus.BAD_REQUEST);
    }
}
