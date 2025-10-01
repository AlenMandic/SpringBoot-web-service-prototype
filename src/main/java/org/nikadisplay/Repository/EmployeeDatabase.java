package org.nikadisplay.Repository;

import org.nikadisplay.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Employee is an Entity --> Database Table named "employee"
@Repository
public interface EmployeeDatabase  extends JpaRepository<Employee, Long> { }