package modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Calculation {
	
    public static int findMax(int arr[]) {
        int max = arr[0]; 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

	@Test
	 public void testFindMax(){
	 assertEquals(8, Calculation.findMax(new int[]{1, 8, 4, 2}));
	 assertEquals(-5,findMax(new int[]{-12,-8,-7,-5,-6}));
	 assertEquals(5, findMax(new int[]{-5, -3, 0, 1, 5}));

	 }
}


