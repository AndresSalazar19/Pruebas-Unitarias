package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class EmployeeTest {

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
        assumeTrue(isMonthOdd()); // Assume current month is odd
        assertEquals(1000 + 386.0F / 12 * 2, workerUSD.cs(), DELTA);
    }

    @Test
    public void testCsWorkerUSDMonthEven() {
        assumeTrue(isMonthEven()); // Assume current month is even
        assertEquals(1000, workerUSD.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorUSDMonthOdd() {
        assumeTrue(isMonthOdd()); // Assume current month is odd
        assertEquals(1000 + 0.35F * 1000 + 386.0F / 12 * 2, supervisorUSD.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorUSDMonthEven() {
        assumeTrue(isMonthEven()); // Assume current month is even
        assertEquals(1000 + 0.35F * 1000, supervisorUSD.cs(), DELTA);
    }

    @Test
    public void testCsManagerUSDMonthOdd() {
        assumeTrue(isMonthOdd()); // Assume current month is odd
        assertEquals(1000 + 0.7F * 1000 + 386.0F / 12 * 2, managerUSD.cs(), DELTA);
    }

    @Test
    public void testCsManagerUSDMonthEven() {
        assumeTrue(isMonthEven()); // Assume current month is even
        assertEquals(1000 + 0.7F * 1000, managerUSD.cs(), DELTA);
    }

    @Test
    public void testCsWorkerOtherCurrencyMonthOdd() {
        assumeTrue(isMonthOdd()); // Assume current month is odd
        assertEquals(1000 * 0.95F + 386.0F / 12 * 2, workerOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsWorkerOtherCurrencyMonthEven() {
        assumeTrue(isMonthEven()); // Assume current month is even
        assertEquals(1000 * 0.95F, workerOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorOtherCurrencyMonthOdd() {
        assumeTrue(isMonthOdd()); // Assume current month is odd
        assertEquals(1000 * 0.95F + (0.2F * 0.35F) + 386.0F / 12 * 2, supervisorOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsSupervisorOtherCurrencyMonthEven() {
        assumeTrue(isMonthEven()); // Assume current month is even
        assertEquals(1000 * 0.95F + (0.2F * 0.35F), supervisorOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsManagerOtherCurrencyMonthOdd() {
        assumeTrue(isMonthOdd()); // Assume current month is odd
        assertEquals(1000 * 0.95F + (0.3F * 0.7F) + 386.0F / 12 * 2, managerOtherCurrency.cs(), DELTA);
    }

    @Test
    public void testCsManagerOtherCurrencyMonthEven() {
        assumeTrue(isMonthEven()); // Assume current month is even
        assertEquals(1000 * 0.95F + (0.3F * 0.7F), managerOtherCurrency.cs(), DELTA);
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

    // Helper methods to determine month parity
    private boolean isMonthOdd() {
        return LocalDate.now().getMonthValue() % 2 != 0;
    }

    private boolean isMonthEven() {
        return LocalDate.now().getMonthValue() % 2 == 0;
    }
}
