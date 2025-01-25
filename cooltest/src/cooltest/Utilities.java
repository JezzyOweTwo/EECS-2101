package cooltest;

import java.util.ArrayList;
import java.util.Arrays;

public class Utilities {
	public static void main (String[] args) {}
	
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

}