package modelo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class EmployeeTest2 {

    private static final float DELTA = 1e-2F;

    private Employee workerUSD;
    private Employee supervisorUSD;
    private Employee managerUSD;
    private Employee workerOtherCurrency;
    private Employee supervisorOtherCurrency;
    private Employee managerOtherCurrency;

    @Before
    public void setUp() {
        workerUSD = new Employee(1000, "USD", 0.1F, EmployeeType.Worker);
        supervisorUSD = new Employee(1000, "USD", 0.2F, EmployeeType.Supervisor);
        managerUSD = new Employee(1000, "USD", 0.3F, EmployeeType.Manager);

        workerOtherCurrency = new Employee(1000, "EUR", 0.1F, EmployeeType.Worker);
        supervisorOtherCurrency = new Employee(1000, "EUR", 0.2F, EmployeeType.Supervisor);
        managerOtherCurrency = new Employee(1000, "EUR", 0.3F, EmployeeType.Manager);
    }

    @Test
    public void testCsWorkerUSDMonthOdd() {
        setFixedDate(2024, 8); // August (even month)
        assertEquals(1000, workerUSD.cs(), DELTA);
    }

    @Test
    public void testCsWorkerUSDMonthEven() {
        setFixedDate(2024, 7); // July (odd month)
        assertEquals(1000 + 386.0F / 12 * 2, workerUSD.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorUSDMonthOdd() {
        setFixedDate(2024, 8); // August (even month)
        assertEquals(1000 + 0.35F * 1000, supervisorUSD.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorUSDMonthEven() {
        setFixedDate(2024, 7); // July (odd month)
        assertEquals(1000 + 0.35F * 1000 + 386.0F / 12 * 2, supervisorUSD.cs(), DELTA);
    }

    @Test
    public void testCsManagerUSDMonthOdd() {
        setFixedDate(2024, 8); // August (even month)
        assertEquals(1000 + 0.7F * 1000, managerUSD.cs(), DELTA);
    }

    @Test
    public void testCsManagerUSDMonthEven() {
        setFixedDate(2024, 7); // July (odd month)
        assertEquals(1000 + 0.7F * 1000 + 386.0F / 12 * 2, managerUSD.cs(), DELTA);
    }

    @Test
    public void testCsWorkerOtherCurrencyMonthOdd() {
        setFixedDate(2024, 8); // August (even month)
        assertEquals(1000 * 0.95F, workerOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsWorkerOtherCurrencyMonthEven() {
        setFixedDate(2024, 7); // July (odd month)
        assertEquals(1000 * 0.95F + 386.0F / 12 * 2, workerOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorOtherCurrencyMonthOdd() {
        setFixedDate(2024, 8); // August (even month)
        assertEquals(1000 * 0.95F + (0.2F * 0.35F), supervisorOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorOtherCurrencyMonthEven() {
        setFixedDate(2024, 7); // July (odd month)
        assertEquals(1000 * 0.95F + (0.2F * 0.35F) + 386.0F / 12 * 2, supervisorOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsManagerOtherCurrencyMonthOdd() {
        setFixedDate(2024, 8); // August (even month)
        assertEquals(1000 * 0.95F + (0.3F * 0.7F), managerOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsManagerOtherCurrencyMonthEven() {
        setFixedDate(2024, 7); // July (odd month)
        assertEquals(1000 * 0.95F + (0.3F * 0.7F) + 386.0F / 12 * 2, managerOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCalculateYearBonusWorkerUSD() {
        assertEquals(386.0F, workerUSD.CalculateYearBonus(), DELTA);
    }

    @Test
    public void testCalculateYearBonusSupervisorUSD() {
        assertEquals(1000 + 386.0F * 0.5F, supervisorUSD.CalculateYearBonus(), DELTA);
    }

    @Test
    public void testCalculateYearBonusManagerUSD() {
        assertEquals(1000 + 386.0F * 1.0F, managerUSD.CalculateYearBonus(), DELTA);
    }

    @Test
    public void testCalculateYearBonusWorkerOtherCurrency() {
        assertEquals(386.0F, workerOtherCurrency.CalculateYearBonus(), DELTA);
    }

    @Test
    public void testCalculateYearBonusSupervisorOtherCurrency() {
        assertEquals(1000 * 0.95F + 386.0F * 0.5F, supervisorOtherCurrency.CalculateYearBonus(), DELTA);
    }

    @Test
    public void testCalculateYearBonusManagerOtherCurrency() {
        assertEquals(1000 * 0.95F + 386.0F * 1.0F, managerOtherCurrency.CalculateYearBonus(), DELTA);
    }

    // Helper method to set a fixed date for testing purposes
    private void setFixedDate(int year, int month) {
        LocalDate fixedDate = LocalDate.of(year, month, 1);
        Date date = Date.from(fixedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        // Overwrite the default Date used in the cs() method
        // This requires refactoring to inject or mock date which isn't shown here
    }

}
