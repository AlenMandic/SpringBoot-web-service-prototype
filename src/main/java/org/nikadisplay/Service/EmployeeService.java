// SERVICE: Employee

package org.nikadisplay.Service;

import org.nikadisplay.Model.Employee;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {

    private final ArrayList<Employee> ourEmployees = new ArrayList<>(); // Mock DB data.
    private final AtomicLong idCounter = new AtomicLong(); // Thread-safe counter for mocking incrementing ID's.

    public EmployeeService() {
        // Adding initial data.
        ourEmployees.add(createEmployee("Jack", 5000));
        ourEmployees.add(createEmployee("John", 6000));
        ourEmployees.add(createEmployee("Jane", 7000));
        ourEmployees.add(createEmployee("Alexander", 5000));
        ourEmployees.add(createEmployee("Mango", 6000));
        ourEmployees.add(createEmployee("Jason", 7000));
    }

    public Employee createEmployee(String employeeName, int employeeSalary) {
        Long id = idCounter.incrementAndGet();

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(employeeName);
        employee.setSalary(employeeSalary);

        return employee;
    }

    // Return all Employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(ourEmployees);
    }

    // Return an employee by ID
    public Employee getEmployeeById(Long employeeId) {

        for (Employee ourEmployee : ourEmployees) {

            if (Objects.equals(ourEmployee.getId(), employeeId)) return ourEmployee;
        }
        throw new NoSuchElementException("Employee with ID " + employeeId + " not found. ");
    }

    public List<Employee> addEmployee(String name, int salary) {

        Employee newEmployee = createEmployee(name, salary);

        if (ourEmployees.size() <= 20 ) {
            ourEmployees.add(newEmployee);
            return ourEmployees; }
        else {
            return null;
        }
    }
}
