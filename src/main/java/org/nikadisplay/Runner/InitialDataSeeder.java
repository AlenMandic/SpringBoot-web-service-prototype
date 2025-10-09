package org.nikadisplay.Runner;

import jakarta.transaction.Transactional;
import org.nikadisplay.Model.Employee;
import org.nikadisplay.Service.EmployeeService;
import org.nikadisplay.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // spring managed bean
public class InitialDataSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    private static final Logger log = LoggerFactory.getLogger(InitialDataSeeder.class);

    public InitialDataSeeder(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService; // need createEmployee from this
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Seed initial DB data only once.
        if(employeeRepository.count() == 0) {

            Employee e1 = employeeService.createEmployee("Jack", 500);
            Employee e2 = employeeService.createEmployee("John", 600);
            Employee e3 = employeeService.createEmployee("Alen", 500);
            Employee e4 = employeeService.createEmployee("Mango", 700);
            Employee e5 = employeeService.createEmployee("Rose", 500);
            Employee e6 = employeeService.createEmployee("Junior", 800);

            List<Employee> ourEmployees = List.of(e1, e2, e3, e4, e5, e6);

            employeeRepository.saveAll(ourEmployees);

            log.info("Initial DB data added successfully!");
        } else {
            log.info("DB data already exists, didn't seed.");
        }
    }
}
