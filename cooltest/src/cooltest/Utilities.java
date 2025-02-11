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
	
	public void insertionSort(int[] arr) {
		if (arr.length<2) return;
		
		for (int i=1;i<arr.length;i++) {
			int target = arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>target) {
				arr[j] = arr[j+1];
				j--;
			}
			arr[j] = target;
		}	
	}
	
	public void selectionSort(int[] arr) {
		if (arr.length<2) return;
		
		for (int i=0;i<arr.length-2;i++) {
			int temp;
			int min = arr[i];
			for (int j=i;j<arr.length;j++) {
				if (arr[j]<min) {
					temp =min;
					min = arr[j];
					arr[j] = temp;
				}
			}
			arr[i] = min;
		}
	}

}