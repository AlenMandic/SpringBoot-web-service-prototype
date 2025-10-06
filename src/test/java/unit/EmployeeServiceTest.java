package unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nikadisplay.Model.Employee;
import org.nikadisplay.Repository.EmployeeRepository;
import org.nikadisplay.Service.EmployeeService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void shouldReturnUserWhenIdExists() {

        // ARRANGE
        Employee testEmp1 = employeeService.createEmployee("testEmp1", 500);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(testEmp1));

        // ACT
        Employee result = employeeService.getEmployeeById(1L);

        //ASSERT
        assertEquals("testEmp1", result.getName());
        verify(employeeRepository).findById(1L);
    }

}
