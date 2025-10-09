package org.nikadisplay.Exception;

// Constructor overloading: Calling EmployeeIdNotFoundException with a String param or Long param determines which constructor is instantiated from RunTimeException.
public class EmployeeIdNotFoundException extends RuntimeException {

    public EmployeeIdNotFoundException(String message) {
        super(message);
    }

    public EmployeeIdNotFoundException(Long employeeId) {
        super("Couldn't find employee with ID: " + employeeId);
    }
}