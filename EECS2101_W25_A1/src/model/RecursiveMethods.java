package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RecursiveMethods {
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
		if (nums.length<=0)
			return false;
		
		if (helperTask2(nums,target,1))
			return true;
	
		return task2(Arrays.copyOfRange(nums,1,nums.length),target);	
	}
	
	public boolean helperTask2(int[] nums, int target, int i) {
		
		if (nums[0]==target)
			return true;
		
		else if (nums[0]>target  ||  i>=nums.length)
			return false;
		
		nums[0]+=nums[i++];
		return helperTask2(nums, target, i);
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
		return helpertask3( h, n,0, arr);
	}
	
	public int helpertask3(int h,int n, int i, int[] path) {
		path = Arrays.copyOf(path, path.length+1);
		path[path.length-1] = i;
		
		int sum =0;
		for (int j=0;j<path.length;j++)
			sum+=path[j];
		
		if (sum==h) return 1;
		else if (sum>h) return 0;
		
		return helpertask3(h,n,1,path) + helpertask3(h,n,2,path);
	}
	
	 /* Inputs of this task are the same as those of Task 3, 
	 * with the same assumptions: n <= h, each climb takes at least 1 step.
	 * 
	 * Output of this task is a HashSet, where each element is an ArrayList.
	 * Each ArrayList encodes a strategy for climbing the staircase.
	 */
	public <T>HashSet<ArrayList<Integer>> task4(int h,int n){
		return null;
	}
	
}

