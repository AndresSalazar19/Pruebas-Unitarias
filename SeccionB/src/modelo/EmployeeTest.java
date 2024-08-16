package modelo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    @Test
    void testCsWorkerUSD() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Worker);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(1000.0f, result, "The salary for Worker in USD should be equal to the salary.");
    }

    @Test
    void testCsWorkerNonUSD() {
        Employee employee = new Employee(1000.0f, "EUR", 0.1f, EmployeeType.Worker);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(950.0f, result, "The salary for Worker in non-USD should be reduced by 5%.");
    }

    @Test
    void testCsSupervisorUSD() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Supervisor);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(1035.0f, result, "The salary plus bonus for Supervisor in USD should be correct.");
    }

    @Test
    void testCsSupervisorNonUSD() {
        Employee employee = new Employee(1000.0f, "EUR", 0.1f, EmployeeType.Supervisor);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(982.5f, result, "The salary plus bonus for Supervisor in non-USD should be correct.");
    }

    @Test
    void testCsManagerUSD() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Manager);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(1070.0f, result, "The salary plus bonus for Manager in USD should be correct.");
    }

    @Test
    void testCsManagerNonUSD() {
        Employee employee = new Employee(1000.0f, "EUR", 0.1f, EmployeeType.Manager);
        float result = employee.cs();
        // Verifica si el resultado es correcto
        assertEquals(975.0f, result, "The salary plus bonus for Manager in non-USD should be correct.");
    }

    @Test
    void testCalculateYearBonusWorker() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Worker);
        float result = employee.CalculateYearBonus();
        // Verifica si el resultado es correcto
        assertEquals(386.0f, result, "The year bonus for Worker should be equal to RMU.");
    }

    @Test
    void testCalculateYearBonusSupervisor() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Supervisor);
        float result = employee.CalculateYearBonus();
        // Verifica si el resultado es correcto
        assertEquals(1436.0f, result, "The year bonus for Supervisor should include salary and RMU * 0.5.");
    }

    @Test
    void testCalculateYearBonusManager() {
        Employee employee = new Employee(1000.0f, "USD", 0.1f, EmployeeType.Manager);
        float result = employee.CalculateYearBonus();
        // Verifica si el resultado es correcto
        assertEquals(1772.0f, result, "The year bonus for Manager should include salary and RMU * 1.0.");
    }
}
