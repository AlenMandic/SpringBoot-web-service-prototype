// SERVICE: Employee

package org.nikadisplay.Service;

import org.nikadisplay.Model.Employee;
import org.nikadisplay.Repository.EmployeeRepository;
import org.nikadisplay.Exception.EmployeeIdNotFoundException;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository; // Our database-repository.

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Employee Factory
    public Employee createEmployee(String employeeName, int employeeSalary) {

        Employee employee = new Employee();
        employee.setName(employeeName);
        employee.setSalary(employeeSalary);

        return employee;
    }

    // Return all Employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    // Return an employee by ID
    public Employee getEmployeeById(Long employeeId) {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeIdNotFoundException(employeeId));
    }

    public boolean addEmployee(String name, int salary) {

        Employee newEmployee = createEmployee(name, salary);

        if (employeeRepository.count() <= 20 ) {
            employeeRepository.save(newEmployee);
            return true; }
        else {
            return false;
        }
    }

    public boolean removeEmployee(Long employeeId) {

        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }

}
