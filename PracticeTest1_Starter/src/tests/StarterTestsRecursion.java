package tests;
import model.RecursiveUtilities;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

/*
 * Study carefully the test methods below. They suggest:
 * 	- the required class(es) and method(s) to be implement in the `model` package
 * 	- how the required class(es) and method(s) should be implemented
 * 
 * Requirements:
 * 	+ Do not create any new class that is not required by the starter tests. 
 * 	+ Any classes created in a non-model package, or not indicated by the starter tests, will NOT be graded.
 *   
 * 	+ Any classes you create must reside in the `model` package and be imported properly.
 * 		For example, creating a new class `Foo` in the `model` package should result in:
 * 			import model.Foo;
 * 
 * 	+ For this test, you should not need to declare attributes. 
 * 		But if you really want to, all attributes you declare in the model classes must be private.
 * 
 * 	+ If necessary, you may define private helper methods. 
 */

public class StarterTestsRecursion {
	/* 
	 * Programming Requirements:
	 * 	- The following programming requirements apply ONLY to class(es) and method(s)
	 * 		that are required to complete by the starter tests below.
	 * 	- This test class focuses on programming with recursion.
	 * 		Therefore:
	 * 			+ You are required to solve the given tasks recursively.
	 * 			+ In addition to the required recursive calls, you may place additional loops if necessary.
	 * 			(That is, solving each task **purely** iteratively is forbidden.) 
	 * 	- You may use methods from the HashSet and ArrayList classes as you see fit.
	 * 
	 * Violating the above programming requirements will result in a penalty (see the test guide for details). 
	 */ 

	@Test
	public void test_getAllSubsets_0() {
		RecursiveUtilities util = new RecursiveUtilities();
		/*
		 * Given as input an ArrayList treated as a set, 
		 * 	return the set of all (empty and non-empty) subsets.
		 * Assume: 
		 * 	+ Input ArrayList contains no duplicates, and it may or may not be sorted.
		 * 	+ Each element (i.e., an ArrayList) in the output HashSet represents a subset,
		 * 		and the order in which numbers appear in each subset ArrayList should be 
		 * 		the same as that in which those numbers appear in the input ArrayList.
		 */
		
		/*
		 * Input: <>
		 * Output: {<>}
		 */
		HashSet<ArrayList<Integer>> subsets = util.getAllSubsets(new ArrayList<Integer>());
		assertTrue(subsets.size() == 1);
		
		ArrayList<Integer> subset0 = new ArrayList<>();
		assertTrue(subsets.contains(subset0));
	}

	@Test
	public void test_getAllSubsets_1() {
		RecursiveUtilities util = new RecursiveUtilities();
		
		/*
		 * Input: <1>
		 * Output: {<>, <1>}
		 */
		HashSet<ArrayList<Integer>> subsets = 
				util.getAllSubsets(new ArrayList<Integer>(Arrays.asList(1)));
		assertTrue(subsets.size() == 2);
		
		ArrayList<Integer> subset0 = new ArrayList<>();
		assertTrue(subsets.contains(subset0));

		ArrayList<Integer> subset1 = new ArrayList<>(Arrays.asList(1));
		assertTrue(subsets.contains(subset1));
	}

	@Test
	public void test_getAllSubsets_2() {
		RecursiveUtilities util = new RecursiveUtilities();
		
		/*
		 * Input: <1, 2>
		 * Output: {<>, <2>, <1>, <1, 2>}
		 */
		HashSet<ArrayList<Integer>> subsets = 
				util.getAllSubsets(new ArrayList<Integer>(Arrays.asList(1, 2)));
		System.out.println(subsets);
		assertTrue(subsets.size() == 4);
		
		ArrayList<Integer> subset0 = new ArrayList<>();
		assertTrue(subsets.contains(subset0));

		ArrayList<Integer> subset1 = new ArrayList<>(Arrays.asList(2));
		assertTrue(subsets.contains(subset1));

		ArrayList<Integer> subset2 = new ArrayList<>(Arrays.asList(1));
		assertTrue(subsets.contains(subset2));

		ArrayList<Integer> subset3 = new ArrayList<>(Arrays.asList(1, 2));
		assertTrue(subsets.contains(subset3));
	}
	
	@Test
	public void test_getAllSubsets_3() {
		RecursiveUtilities util = new RecursiveUtilities();
		
		/*
		 * Input: <1, 2, 3>
		 * Output: {<>, <3>, <2>, <2, 3>, <1>, <1, 3>, <1, 2>, <1, 2, 3>}
		 */
		HashSet<ArrayList<Integer>> subsets = 
				util.getAllSubsets(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		assertTrue(subsets.size() == 8);

		ArrayList<Integer> subset0 = new ArrayList<>();
		assertTrue(subsets.contains(subset0));

		ArrayList<Integer> subset1 = new ArrayList<>(Arrays.asList(3));
		assertTrue(subsets.contains(subset1));

		ArrayList<Integer> subset2 = new ArrayList<>(Arrays.asList(2));
		assertTrue(subsets.contains(subset2));

		ArrayList<Integer> subset3 = new ArrayList<>(Arrays.asList(2, 3));
		assertTrue(subsets.contains(subset3));
		
		ArrayList<Integer> subset4 = new ArrayList<>(1);
		assertTrue(subsets.contains(subset4));

		ArrayList<Integer> subset5 = new ArrayList<>(Arrays.asList(1, 3));
		assertTrue(subsets.contains(subset5));

		ArrayList<Integer> subset6 = new ArrayList<>(Arrays.asList(1, 2));
		assertTrue(subsets.contains(subset6));

		ArrayList<Integer> subset7 = new ArrayList<>(Arrays.asList(1, 2, 3));
		assertTrue(subsets.contains(subset7));
	}
}