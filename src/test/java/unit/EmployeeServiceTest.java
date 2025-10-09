package unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nikadisplay.Model.Employee;
import org.nikadisplay.Repository.EmployeeRepository;
import org.nikadisplay.Service.EmployeeService;
import org.nikadisplay.Exception.EmployeeIdNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Following the AAA pattern: Arrange, Act, Assert
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void getEmployeeById_IdExists_ReturnsTrue() {

        // ARRANGE
        Employee testEmp1 = employeeService.createEmployee("testEmp1", 500);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(testEmp1));

        // ACT
        Employee result = employeeService.getEmployeeById(1L);

        //ASSERT
        assertEquals("testEmp1", result.getName());
        verify(employeeRepository).findById(1L);
    }

    @Test
    void getEmployeeById_IdDoesntExist_ReturnsException() {

        // ARRANGE
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        // ACT
        EmployeeIdNotFoundException thrown = assertThrows(
                EmployeeIdNotFoundException.class,
                () -> employeeService.getEmployeeById(1L)
        );

        // ASSERT
        assertTrue(thrown.getMessage().contains("Couldn't find employee with ID:")); // From our EmployeeIdNotFoundException
    }

    @Test
    void addEmployee_OverMaxLimit_ReturnsFalse() {

        when(employeeRepository.count()).thenReturn(21L);

        boolean result = employeeService.addEmployee("testEmp1", 500);

        assertFalse(result);
    }

}
