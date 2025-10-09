package org.nikadisplay.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handling REST Exceptions on missing ID's: Employee Adding, Getting, and Deleting by ID.
    @ExceptionHandler(EmployeeIdNotFoundException.class)

    public ResponseEntity<EmployeeErrorResponse> handleEmployeeIdNotFound(EmployeeIdNotFoundException ex) {
        LocalDateTime currentTime = LocalDateTime.now();

        EmployeeErrorResponse error = new EmployeeErrorResponse("NOT_FOUND", ex.getMessage(), currentTime);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}