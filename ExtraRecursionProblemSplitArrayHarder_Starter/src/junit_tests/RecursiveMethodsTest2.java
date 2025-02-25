package junit_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import model.RecursiveMethods;

public class RecursiveMethodsTest2 {
	
	@Test
	public void testSplitArrayHarder_01() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {2, 2};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>(Arrays.asList(2));
		ArrayList<Integer> expectedGroup2 = new ArrayList<>(Arrays.asList(2));
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_02() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {2, 3};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>();
		ArrayList<Integer> expectedGroup2 = new ArrayList<>();
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_03() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {5, 2, 3};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>(Arrays.asList(5));
		ArrayList<Integer> expectedGroup2 = new ArrayList<>(Arrays.asList(2, 3));
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_04() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {5, 2, 2};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>();
		ArrayList<Integer> expectedGroup2 = new ArrayList<>();
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_05() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 1, 1, 1, 1, 1};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>(Arrays.asList(1, 1, 1));
		ArrayList<Integer> expectedGroup2 = new ArrayList<>(Arrays.asList(1, 1, 1));
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_06() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 1, 1, 1, 1};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>();
		ArrayList<Integer> expectedGroup2 = new ArrayList<>();
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_07() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>();
		ArrayList<Integer> expectedGroup2 = new ArrayList<>();
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_08() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>();
		ArrayList<Integer> expectedGroup2 = new ArrayList<>();
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_09() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {3, 5};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>();
		ArrayList<Integer> expectedGroup2 = new ArrayList<>();
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_10() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {5, 3, 2};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>(Arrays.asList(5));
		ArrayList<Integer> expectedGroup2 = new ArrayList<>(Arrays.asList(3, 2));
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_11() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {2, 2, 10, 10, 1, 1};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>(Arrays.asList(2, 10, 1));
		ArrayList<Integer> expectedGroup2 = new ArrayList<>(Arrays.asList(2, 10, 1));
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_12() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 2, 2, 10, 10, 1, 1};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>();
		ArrayList<Integer> expectedGroup2 = new ArrayList<>();
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_13() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 2, 3, 10, 10, 1, 1};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>(Arrays.asList(1, 2, 10, 1));
		ArrayList<Integer> expectedGroup2 = new ArrayList<>(Arrays.asList(3, 10, 1));
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
	
	@Test
	public void testSplitArrayHarder_14() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] input = {1, 3, 2, 4};
		ArrayList<ArrayList<Integer>> output = rm.splitArrayHarder(input);
		ArrayList<Integer> expectedGroup1 = new ArrayList<>(Arrays.asList(1, 4));
		ArrayList<Integer> expectedGroup2 = new ArrayList<>(Arrays.asList(3, 2));
		assertEquals(expectedGroup1, output.get(0));
		assertEquals(expectedGroup2, output.get(1));
		assertEquals(2,output.size());
	}
}
