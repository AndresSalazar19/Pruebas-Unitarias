package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void testCsWorkerUSD() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Worker);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(1000.0f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCsWorkerNonUSD() {
        Employee employee = new Employee(1000.0f, "EUR", 0.1f, EmployeeType.Worker);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(950.0f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCsSupervisorUSD() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Supervisor);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(1035.0f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCsSupervisorNonUSD() {
        Employee employee = new Employee(1000.0f, "EUR", 0.1f, EmployeeType.Supervisor);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(982.5f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCsManagerUSD() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Manager);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(1070.0f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCsManagerNonUSD() {
        Employee employee = new Employee(1000.0f, "EUR", 0.1f, EmployeeType.Manager);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(975.0f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCalculateYearBonusWorker() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Worker);
        float result = employee.CalculateYearBonus();
        // Verifica si el resultado es correcto
        assertEquals(386.0f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCalculateYearBonusSupervisor() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Supervisor);
        float result = employee.CalculateYearBonus();
        // Verifica si el resultado es correcto
        assertEquals(1436.0f, result, 0.01f); // Added delta of 0.01f
    }

    @Test
    public void testCalculateYearBonusManager() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Manager);
        float result = employee.CalculateYearBonus();
        // Verifica si el resultado es correcto
        assertEquals(1772.0f, result, 0.01f); // Added delta of 0.01f
    }
}
