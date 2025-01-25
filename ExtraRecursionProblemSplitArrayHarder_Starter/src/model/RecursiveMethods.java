package model;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 */
public class RecursiveMethods {

	public boolean splitArray(int[] array) {
		return splitArrayHelper(array,0,0,0);
	}
	
	private boolean splitArrayHelper(int[] array, int j,int leftSum,int rightSum) {
		
		if (leftSum==rightSum && j==array.length) return true;
		else if (j==array.length) return false;
		
		// puts current index into left index array or right index array
		return splitArrayHelper(array,j+1,leftSum+ array[j],rightSum)|
		splitArrayHelper(array,j+1,leftSum,rightSum + array[j]);			   
	}
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
		if (ns.length<=1) return temp;
		//ArrayList<ArrayList<Integer>>poop = splitArrayHarder3(ns,0,0,0,temp);
		
		ArrayList<ArrayList<Integer>>poop= splitArrayHarder4(ns,0,0,new ArrayList<Integer>(),0,new ArrayList<Integer>());
		return (poop.size()==0)?temp:poop;
	}
	
	public ArrayList<ArrayList<Integer>> splitArrayHarder4(int[] ns,int i,int leftSum,ArrayList<Integer>leftValues,int rightSum,ArrayList<Integer>rightValues) {
		if (i==ns.length&&leftSum==rightSum) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<>(2);
			temp.add(new ArrayList<Integer>(leftValues));
			temp.add(new ArrayList<Integer>(rightValues));
			return temp;
		}
		
		if (i==ns.length)
			return new ArrayList<ArrayList<Integer>>(2);
		
		ArrayList<Integer> temp = new ArrayList<Integer>(leftValues);
		temp.add(ns[i]);
		ArrayList<ArrayList<Integer>> answer = splitArrayHarder4(ns,i+1,leftSum+ns[i],temp,rightSum,new ArrayList<Integer>(rightValues));                                                                                                                                                  
		
		temp = new ArrayList<Integer>(rightValues);
		temp.add(ns[i]);
		answer.addAll( splitArrayHarder4(ns,i+1,leftSum,new ArrayList<Integer>(leftValues),rightSum+ns[i],temp));
		return answer;
	}
	
	public ArrayList<ArrayList<Integer>>splitArrayHarder(int[] ns,int i,int leftSum,int rightSum, ArrayList<ArrayList<Integer>> validSol){
//		if (i>=ns.length-1&&leftSum==rightSum) return new ArrayList<ArrayList<Integer>>(validSol);
//		if (i>=ns.length-1) return new ArrayList<ArrayList<Integer>>(validSol);
//		
//		ArrayList<ArrayList<Integer>> answer;
//		
//		validSol.get(0).add(ns[i+1]);
//		answer = splitArrayHarder(ns,i+1,leftSum+ns[i+1],rightSum,new ArrayList<ArrayList<Integer>>(validSol));
//		if (answer.get(0).size()>0) return validSol;
//		validSol.get(1).add(ns[i+1]);
//		answer =  splitArrayHarder(ns,i+1,leftSum,rightSum+ns[i+1],new ArrayList<ArrayList<Integer>>(validSol));
//		
//		return answer;
		return null;
	}
	
	public ArrayList<ArrayList<Integer>>splitArrayHarder3(int[] ns,int i,int leftSum,int rightSum, ArrayList<ArrayList<Integer>> validSol){
		// valid solution found
		if (i==ns.length&&leftSum==rightSum) return new ArrayList<ArrayList<Integer>>(validSol);
		
		// invalid solution
		if (i==ns.length) return new ArrayList<ArrayList<Integer>>(2);
		
		// left checking
		validSol = new ArrayList<ArrayList<Integer>>(validSol);
		validSol.set(0, new ArrayList<>(validSol.get(0)));
		validSol.get(0).add(ns[i]);
		ArrayList<ArrayList<Integer>> answer = splitArrayHarder3(ns,i+1,leftSum+ns[i],rightSum,validSol);
		
		// right checking
		validSol = new ArrayList<ArrayList<Integer>>(validSol);
		validSol.set(1, new ArrayList<>(validSol.get(1)));
		validSol.get(1).add(ns[i]);
		answer.addAll(  splitArrayHarder3(ns,i+1,leftSum,rightSum+ns[i],validSol));
		
		return answer;
	}

//	private ArrayList<ArrayList<Integer>> splitArrayHarder(int[] ns, int i,int leftSum,int rightSum,ArrayList<ArrayList<Integer>> validSolution){
//		// bullshit prevention
//		if (ns.length<=0) return validSolution;
//		
//		if (i==ns.length -1 && leftSum==rightSum) 
//			return null;
//			
//		else if (i==ns.length-1) {
//			return null;
//			//validSolution.set(0, new ArrayList<Integer>());	// empties the first arraylist
//			//validSolution.set(1, new ArrayList<Integer>());	// empties the second arraylist
//		}
//		
//		splitArrayHarder(ns,i+1,leftSum+ns[i+1],rightSum,(validSolution.get(0).add(i)) ? validSolution:null); 
//		splitArrayHarder(ns,i+1,leftSum,rightSum+ns[i+1],(validSolution.get(1).add(i)) ? validSolution:null);
//
//		return validSolution;
//	}
	
	private ArrayList<ArrayList<Integer>> splitArrayHarder2(int[] ns,int i, int leftSum,Integer[] leftIndexes,int rightSum,Integer[] rightIndexes){
//		if (leftIndexes.length>=2 && leftIndexes[leftIndexes.length-1]==0)
//			leftIndexes[leftIndexes.length-1] =i;
//		
//		else if (rightIndexes.length>=2 && rightIndexes[rightIndexes.length-1]==0)
//			rightIndexes[rightIndexes.length-1] =i;
//		
//		// bullshit prevention
//		if (ns.length<=0) {
//			ArrayList<ArrayList<Integer>> temp = new ArrayList<>(2);
//			temp.add(new ArrayList<Integer>());
//			temp.add(new ArrayList<Integer>());
//			return temp;
//		}
//		
//		// finished iterating and the sums match
//		if(i==ns.length-1 && leftSum==rightSum) {
//			ArrayList<ArrayList<Integer>> temp = new ArrayList<>(2);
//			temp.get(0).addAll(Arrays.asList(leftIndexes));
//			temp.get(1).addAll(Arrays.asList(rightIndexes));
//			return temp;
//		}
//			
//		// finished iterating and the sums don't match
//		else if (i==ns.length-1) {
//			ArrayList<ArrayList<Integer>> temp = new ArrayList<>(2);
//			temp.add(new ArrayList<Integer>());
//			temp.add(new ArrayList<Integer>());
//			return temp;
//		}
//		
//		ArrayList<ArrayList<Integer>> temp = new ArrayList<>(2);
//		temp = splitArrayHarder2(ns,i+1,leftSum+ns[i+1],Arrays.copyOfRange(leftIndexes, 0, leftIndexes.length+1),rightSum,rightIndexes);
//		if (temp.get(0).size()>0) return temp;
//		temp = splitArrayHarder2(ns,i+1,leftSum,leftIndexes,rightSum+ns[i+1],Arrays.copyOfRange(rightIndexes, 0, rightIndexes.length+1));
//		return temp;
		return null; // i just put that here so the code would compile.
	}
}


