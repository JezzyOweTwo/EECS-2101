package junit_tests;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;
import model.RecursiveMethods;

public class GetAllPermutationsTest {

    @Test
    public void testPermutationsOfThreeElements() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        HashSet<ArrayList<Integer>> expected = new HashSet<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(1, 3, 2)),
            new ArrayList<>(Arrays.asList(2, 1, 3)),
            new ArrayList<>(Arrays.asList(2, 3, 1)),
            new ArrayList<>(Arrays.asList(3, 1, 2)),
            new ArrayList<>(Arrays.asList(3, 2, 1))
        ));

        HashSet<ArrayList<Integer>> result = RecursiveMethods.getAllPermutations(input);
        assertEquals(expected, result); 
    }

    @Test
    public void testPermutationsOfTwoElements() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(4, 5));
        HashSet<ArrayList<Integer>> expected = new HashSet<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(4, 5)),
            new ArrayList<>(Arrays.asList(5, 4))
        ));

        HashSet<ArrayList<Integer>> result = RecursiveMethods.getAllPermutations(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPermutationOfSingleElement() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(7));
        HashSet<ArrayList<Integer>> expected = new HashSet<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(7))
        ));

        HashSet<ArrayList<Integer>> result = RecursiveMethods.getAllPermutations(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPermutationOfEmptyList() {
        ArrayList<Integer> input = new ArrayList<>();
        HashSet<ArrayList<Integer>> expected = new HashSet<>(Arrays.asList(
            new ArrayList<>()
        ));

        HashSet<ArrayList<Integer>> result = RecursiveMethods.getAllPermutations(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPermutationsWithDuplicateElements() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 1, 2));
        HashSet<ArrayList<Integer>> expected = new HashSet<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1, 1, 2)),
            new ArrayList<>(Arrays.asList(1, 2, 1)),
            new ArrayList<>(Arrays.asList(2, 1, 1))
        ));

        HashSet<ArrayList<Integer>> result = RecursiveMethods.getAllPermutations(input);
        assertEquals(expected, result);
    }
}