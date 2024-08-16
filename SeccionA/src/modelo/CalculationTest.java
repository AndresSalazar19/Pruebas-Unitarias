package modelo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculationTest {
	@Test
	 public void testFindMax(){
	 assertEquals(8, Calculation.findMax(new int[]{1, 8, 4, 2}));
	 assertEquals(-5,Calculation.findMax(new int[]{-12,-8,-7,-5,-6}));
	 assertEquals(5, Calculation.findMax(new int[]{-5, -3, 0, 1, 5}));

	 }
}
