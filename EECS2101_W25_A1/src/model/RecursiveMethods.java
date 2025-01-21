package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RecursiveMethods {
	public static HashSet<ArrayList<Integer>> solutions =  new HashSet<>();
	
	public RecursiveMethods() {}
	
	 /* Input: A string `in_string`
	 * Output: A string `out_string`
	 * Problem: 
	 * 	Given `in_string` which contains a single pair of parentheses, compute recursively and 
	 * 	return `out_string` made of only the pair of parentheses and their enclosed characters. 
	 */
	public String task1(String input) {
		// if the use enters a string that does not contains "()", 
		// the empty string is returned.
		if (input.length()<2)
			return "";
		
		if (input.charAt(0)=='('  &&  input.charAt(input.length()-1)==')')
			return input;
		else if (input.charAt(0)=='(')
			return task1(input.substring(0,input.length()-1));
		else 
			return task1(input.substring(1,input.length()));
	}
	
	 /* Inputs: An array `a` of integers and an integer `target`
	 * Output: A boolean `result`
	 * Problem: 
	 * 	Given an array `a` of integers, compute recursively and
	 * 	return a boolean `result` which indicates 
	 * 	whether or not it's possible to choose a group of some of the integers in `a`, 
	 * 	such that this chosen group of integers sums up to the given `target`.   
	 * 
	 * Hint: You should not need to use a loop.  
	 */
	public boolean task2(int[] nums, int target) {
		int[] indexes = {};
		return this.helperTask2(nums,target,indexes);
	}
	
	public boolean helperTask2(int[] nums, int target, int[] indexes) {	
		int sum=0;
		for (int j:indexes) 
			sum+=nums[j];
		
		if (sum==target)
			return true;
		
		else if (sum>target)
			return false;
		
		indexes = Arrays.copyOf(indexes, indexes.length+1);
		
		boolean result=false;
		for (int j=0;j<nums.length-indexes.length;j++) {
	//		indexes[indexes.length-1]=indexes[j]+1;
			result = result | helperTask2(nums,target,indexes );
		}
		return result;
	}
	
	 /* Inputs: An integer `h` (height of a staircase) and an integer `n` (maximum steps of each climb)
	 * Output: An integer `result`
	 * Problem: 
	 * 	Given `h` and `n`, compute recursively and
	 * 	return an integer `result` which indicates 
	 * 	the number of possible ways for climbing a staircase of height `h`, 
	 * 	while each climb is **up to** `n` steps.    
	 * 
	 * Assumption: n <= h, each climb takes at least 1 step
	 */
	public int task3(int h,int n) {
		int [] arr = {};
		int response =helpertask3( h, n,0, arr);
		HashSet<ArrayList<Integer>> sol = new HashSet<>(this.solutions); // super ghetto way of making helpertask3 reuseable.
		this.solutions=new HashSet<ArrayList<Integer>>();				// super ghetto way of making helpertask3 reuseable.
		return response;
	}
	
	public int helpertask3(int h,int n, int i, int[] path) {
		path = Arrays.copyOf(path, path.length+1);
		path[path.length-1] = i;
		
		int sum = 0;
		for (int j=0;j<path.length;j++)
			sum+=path[j];
		
		if (sum==h) {
			ArrayList<Integer> validsolution = new ArrayList<>();
			for (int j:path) {
				if (j==0) continue;		// all of my paths start at zero, but i don't want that to actually be added to the array. 
				validsolution.add(j);
			}
				
			this.solutions.add(validsolution);
			return 1;
		}
		else if (sum>h) return 0;
		
		int sum2=0;
		
		for (int k=n;k>0;k--) {
			sum2+=helpertask3(h,n,k,path);
		}
		return sum2;
	//	return helpertask3(h,n,1,path) + helpertask3(h,n,2,path);
	}
	
	 /* Inputs of this task are the same as those of Task 3, 
	 * with the same assumptions: n <= h, each climb takes at least 1 step.
	 * 
	 * Output of this task is a HashSet, where each element is an ArrayList.
	 * Each ArrayList encodes a strategy for climbing the staircase.
	 */
	public HashSet<ArrayList<Integer>> task4(int h,int n){
		int [] arr = {};
		helpertask3( h, n,0, arr);
		HashSet<ArrayList<Integer>> sol = new HashSet<>(this.solutions); // super ghetto way of making helpertask4 reuseable.
		this.solutions=new HashSet<ArrayList<Integer>>();				// super ghetto way of making helpertask4 reuseable.
		return sol;
	}
	
}

