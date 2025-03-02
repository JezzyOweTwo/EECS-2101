package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RecursiveMethods {
	private static HashSet<ArrayList<Integer>> validSauce = new HashSet<>();
	
	public RecursiveMethods() {}
	
	 /* Input: A string `in_string`
	 * Output: A string `out_string`
	 * Problem: 
	 * 	Given `in_string` which contains a single pair of parentheses, compute recursively and 
	 * 	return `out_string` made of only the pair of parentheses and their enclosed characters. 
	 */
	public String task1(String input) {
		// if a string that's less than two characters is inputted, the original input is returned.
			
		// onces the first char is '(' and the last is ')', return input
		if (input.charAt(0)=='('  &&  input.charAt(input.length()-1)==')')
			return input;
		
		// once first char is '(', start removing the last char over and over
		else if (input.charAt(0)=='(')
			return task1(input.substring(0,input.length()-1));
		
		// start by removing characters from the beginning of the word.
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
	
	
	
	
	
	
	public boolean helpertask2(int[] nums, int target, int curnum, int i){
		if (curnum==target) return true;
		if (curnum>target) return false;
		
		return helpertask2(nums, target, curnum+nums[i+1],i+1) || helpertask2(nums, target, curnum,i+1);
		
	}
	
	
	public boolean task2(int[] nums, int target) {
		if (nums.length<=0)return false;
		return helperTask2(nums,0,target,0);	
	}
	
	private boolean helperTask2(int[] nums,int curnum, int target, int sum) {
		
		// if you've reached the target, you CHILL
		if (sum==target)
			return true;
		
		// if you've overshot the target, or iterated through the whole array, you unchill
		else if (curnum>=nums.length || sum>target)
			return false;
		
		// either option A: you include the current number in your solution
		// or     option B: you don't include the current number in your solution.
		return helperTask2(nums,curnum+1,target,sum+nums[curnum]) ||
			   helperTask2(nums,curnum+1,target,sum);
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
		if (h<=0||n<=0) return 0;	// bullshit prevention
		//return helpertask3(h,n,0,0,temp);
		return otherhelpertask3(h,n,0);
	}
	
	public int otherhelpertask3(int height,int maxStep,int sum) {
		if (sum==height) return 1;		// you've successfully got da current sum
		else if (sum>height) return 0;	// you've overshot the sum
		
		int solutionCount=0;
		
		for (int i=1;i<=maxStep;i++) 
			solutionCount+=otherhelpertask3(height,maxStep,sum+i);
		
		return solutionCount;
	}
	
	
	public int heklpertaskthree(int height, int maxStep,int curVal) {
		if (curVal==height) return 1;
		if (curVal>height) return 0;
		
		int validSol=0;
		for (int i=1;i<=maxStep;i++) {
			validSol = heklpertaskthree(height, maxStep,curVal+i);
		}
		return validSol;
	}
	
	
	
	// Ok technically this is also what i use to solve q4
	public int helpertask3(int height,int maxStep, int sum,int i,Integer[] currentSol) {		
		currentSol = Arrays.copyOfRange(currentSol, 0, currentSol.length+1);	// makes array one bigger
		currentSol[currentSol.length-1] = i;									// adds i to the current solution
		
		// if the current path has the correct height, return a 1, and add it to validSauce
		if (sum==height) {
			ArrayList<Integer>temp = new ArrayList<>(Arrays.asList(currentSol));
			temp.remove(0);	// all my paths start with index 0. This manually removes that.
			validSauce.add(temp);
			return 1;
		}

		// If you've overshot the target, this path is not valid. give a 0, dumbass.
		else if (sum>height) return 0;
		
		int solutionCount = 0;
		
		// iterates through da tree, with the maxiumum size of each step being determined by j
		for (int j =1;j<=maxStep;j++) 
			solutionCount += helpertask3(height,maxStep, sum+j,j,currentSol);
		
		return solutionCount;
	}
	
	 /* Inputs of this task are the same as those of Task 3, 
	 * with the same assumptions: n <= h, each climb takes at least 1 step.
	 * 
	 * Output of this task is a HashSet, where each element is an ArrayList.
	 * Each ArrayList encodes a strategy for climbing the staircase.
	 */
	
	public void task4Helper(HashSet<ArrayList<Integer>> answer, ArrayList<Integer> currentSol, int height,int maxStep,int curVal) {
		if (curVal==height) {
			answer.add(new ArrayList<Integer>(currentSol));
			return;
		}
		else if (curVal>height)return;
		
		for (int i=1;i<maxStep;i++) {
			
		}
	}
	
	
	public HashSet<ArrayList<Integer>> task4(int h,int n){
		HashSet<ArrayList<Integer>> temp = new HashSet<>();		// creates a new HashSet to hold the valid solutions
		if (h<=0||n<=0) return temp;							// bullshit prevention
		task4helper(h,n,0,new ArrayList<Integer>(),temp);	// all valid solutions are appended to temp. 
		return temp;											// temp is returned
	}
	
	public void task4helper(int height,int maxStep,int sum,ArrayList<Integer> currentSol,HashSet<ArrayList<Integer>> solutions) {
		// if you've hit the target, add the sucessful solution to solutions, and stop recursing
		if (sum==height) {
			solutions.add (new ArrayList<Integer> (currentSol));
			return;
		}
		
		// if you've overshot the target, this solution is not valid. Stop recursing.
		else if (sum>height) return;
		
		// iterates every possible combination of values for the staircase, from 1 to n.
		for (int i=1;i<=maxStep;i++) {
			ArrayList<Integer> temp = new ArrayList<>(currentSol);	// currentSol needs to be copied to avoid issues with passing by reference
			temp.add(i);											// adds a step to currentSol
			task4helper(height,maxStep,sum+i,temp,solutions);		// recurisvely calls itself.
		}
	}
}

