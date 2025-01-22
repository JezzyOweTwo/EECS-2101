package cooltest;

import java.util.ArrayList;
import java.util.Arrays;

public class Utilities {
	public static void main (String[] args) {
		int[] coolArray = {5,2,3};
		boolean result = splitArray(coolArray);
		System.out.println("obviously its "+result);
	}
	
	public int binarySearch(int[] nums, int target) {
		int lp=0;
		int rp= nums.length-1;
		
		while (lp<=rp) {		
			int mid = (lp + rp) / 2;
			
			if (nums[mid]==target) return mid;
			
			else if (nums[mid]>target) 
				rp=mid-1;
			else if (nums[mid]<target)
				lp=mid+1;
		}
		
		return -1;
	}
	
	private Utilities() {};	// private contructor LOL 
							// don't try to instantiate this shit
	
	public static boolean splitArray(int[] array) {
		return splitArrayHelper(array,0,0,0);
	}
	
	private static boolean splitArrayHelper(int[] array, int j,int leftSum,int rightSum) {
		
		if (leftSum==rightSum && j==array.length) return true;
		else if (j==array.length) return false;
		
		// puts current index into left index array or right index array
		return splitArrayHelper(array,j+1,leftSum+ array[j],rightSum)|
			   splitArrayHelper(array,j+1,leftSum,rightSum + array[j]);			   
	}
	
	public static ArrayList<ArrayList<Integer>> splitArrayHarder(int[] ns) {
		Integer[] temp= {};
		ArrayList<ArrayList<Integer>> validSolution = new ArrayList<>(2);
		return splitArrayHarder(ns, 0,0,temp,0,temp,validSolution);
	}
	
	private static ArrayList<ArrayList<Integer>> splitArrayHarder(int[] ns, int i,int leftSum,Integer[] indexleft,int rightSum,Integer[] indexright,ArrayList<ArrayList<Integer>> validSolution){
		// add the new index to the array
		
		if (i==ns.length && leftSum==rightSum) {
			validSolution.add(new ArrayList<Integer>(Arrays.asList(indexleft)));
			validSolution.add(new ArrayList<Integer>(Arrays.asList(indexright)));
			return validSolution;
		}
			
		else if (i==ns.length) {
			validSolution.add(new ArrayList<Integer>());
			validSolution.add(new ArrayList<Integer>());
			return validSolution;
		}
				
		return splitArrayHarder(ns,i+1,leftSum+ns[i+1],indexleft,rightSum,indexright)
			   splitArrayHarder(ns,i+1,leftSum,indexleft,rightSum+ns[i+1],indexright);
	}
}