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

        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<?> addNewEmployee(@RequestParam String newName, @RequestParam int newSalary) {

        boolean tryAddNewEmployee = employeeService.addEmployee(newName, newSalary);

        if (tryAddNewEmployee) {
            return  ResponseEntity.status(HttpStatus.CREATED).body("Added a new employee!");
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Couldn't add new employee");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable Long id) {

        boolean updatedList = employeeService.removeEmployee(id);

        if(updatedList) {
            return ResponseEntity.ok("Removed employee." );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found. ");
    }

}
