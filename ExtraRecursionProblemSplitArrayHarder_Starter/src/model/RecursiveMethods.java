package model;

import java.util.ArrayList;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 */
public class RecursiveMethods {
	
	/*
	 * A useful extension to the original `splitArray` problem.
	 * 
	 * If a split of equal sums is possible, return an ArrayList of size 2: 
	 * 	- index 1 of the returned ArrayList stores the list of integers representing group 1.
	 * 	- index 0 of the returned ArrayList stores the list of integers representing group 1.
	 * 
	 * If a split is not possible, both indices store empty lists.
	 * 
	 * Requirements (as an example, see `testSplitArrayHarder_14` in RecursiveMethodTests): 
	 * 	When an equal split is possible, then:
	 * 		+ The first element of the input array `ns` (i.e., ns[0]) must be put into group1.
	 * 		+ The order in which elements appear in each group must be the same as they appear in the input array `ns`.
	 * 
	 * Assumption: when a split is possible, there is a single, unique split only.
	 * 
	 * Hints:
	 * 		+ Pass as arguments two empty lists, representing group1 and group2, to the call to a recursive helper method.
	 * 		+ Via call by value, the two lists should be modified properly among as the recursion tree is built.
	 * 		+ Upon the call terminating, return a list containing the two modified lists.      		  
	 */

	public ArrayList<ArrayList<Integer>> splitArrayHarder(int [] ns){
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>(2);
		temp.add(new ArrayList<Integer>());
		temp.add(new ArrayList<Integer>());
		return splitArrayHarder(ns,0,0,0,temp);
	}

	private ArrayList<ArrayList<Integer>> splitArrayHarder(int[] ns, int i,int leftSum,int rightSum,ArrayList<ArrayList<Integer>> validSolution){
		// add the new index to the array
		
		if (i==ns.length && leftSum==rightSum) 
			return validSolution;
			
		else if (i==ns.length) 
			return null;
		
			
		splitArrayHarder(ns,i+1,leftSum+ns[i+1],rightSum,(validSolution.get(0).add(i)) ? validSolution:null); 
		splitArrayHarder(ns,i+1,leftSum,rightSum+ns[i+1],(validSolution.get(1).add(i)) ? validSolution:null);

		// validSolution.set(0, new ArrayList<Integer>());	// empties the first arraylist
		// validSolution.set(1, new ArrayList<Integer>());	// empties the second arraylist
		return validSolution;
	}

}
