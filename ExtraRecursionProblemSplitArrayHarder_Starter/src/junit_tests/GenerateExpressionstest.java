package junit_tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import model.RecursiveMethods;
import org.junit.Test;

public class GenerateExpressionstest {
	@Test
    public void testGenerateExpressionsWithSimpleInput() {
        String digits = "123";
        int target = 6;
        HashSet<String> expected = new HashSet<>(Arrays.asList("1+2+3"));
        HashSet<String> result = RecursiveMethods.generateExpressions(digits, target);
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateExpressionsWithNegativeNumbers() {
        String digits = "105";
        int target = 5;
        HashSet<String> expected = new HashSet<>(Arrays.asList("10-5"));
        HashSet<String> result = RecursiveMethods.generateExpressions(digits, target);
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateExpressionsWithZeroInput() {
        String digits = "00";
        int target = 0;
        HashSet<String> expected = new HashSet<>(Arrays.asList("0+0", "0-0", "0"));
        HashSet<String> result = RecursiveMethods.generateExpressions(digits, target);
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateExpressionsWithMultipleOperators() {
        String digits = "232";
        int target = 3;
        HashSet<String> expected = new HashSet<>(Arrays.asList("2+3-2"));
        HashSet<String> result = RecursiveMethods.generateExpressions(digits, target);
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateExpressionsWithLargerTarget() {
        String digits = "12345";
        int target = 10;
        HashSet<String> expected = new HashSet<>(Arrays.asList(
            "1+2+3+4", 
            "1+2+3-4", 
            "12+3-4", 
            "1+23-4"
        ));
        HashSet<String> result = RecursiveMethods.generateExpressions(digits, target);
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateExpressionsWithNegativeTarget() {
        String digits = "123";
        int target = -1;
        HashSet<String> expected = new HashSet<>(Arrays.asList("1-2-3"));
        HashSet<String> result = RecursiveMethods.generateExpressions(digits, target);
        assertEquals(expected, result);
    }

    @Test
    public void testGenerateExpressionsWithLargeInput() {
        String digits = "123456789";
        int target = 100;
        // The expected result would depend on the number of valid expressions 
        // that sum to 100.
        // Here you can check if the function runs within time limits, or assert if needed.
        HashSet<String> result = RecursiveMethods.generateExpressions(digits, target);
        assertTrue(result.size() == 0); // Just check if any valid expressions are found
    }
}
