// WORK IN PROGRESS, UNFINISHED

package Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nikadisplay.Model.Employee;
import org.nikadisplay.Repository.EmployeeRepository;
import org.nikadisplay.Service.EmployeeService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    @DisplayName("Should add an employee when under the 20 limit")
    void addEmployee_UnderLimit_ReturnsTrue() {
        // Given
        when(employeeRepository.count()).thenReturn(10L);
        when(employeeRepository.save(any(Employee.class)));

    }
}
