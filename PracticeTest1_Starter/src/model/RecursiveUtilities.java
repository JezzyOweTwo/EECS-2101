package model;

import java.util.ArrayList;
import java.util.HashSet;

public class RecursiveUtilities {
	public RecursiveUtilities() {}
	
	public HashSet<ArrayList<Integer>> getAllSubsets (ArrayList<Integer> allNums){
		HashSet<ArrayList<Integer>> answer = new HashSet<>();
		getAllSubsetsHelper (answer,allNums);
		answer.add(new ArrayList<>());
		return answer;
	}
	
	public void getAllSubsetsHelper (HashSet<ArrayList<Integer>> allNums,ArrayList<Integer> curSet){
		ArrayList<Integer> newSet = new ArrayList<>(curSet);	
		allNums.add(newSet);
		
		if (curSet.size()==1) return;
		
		for (int i=0;i<curSet.size();i++) {
			newSet = new ArrayList<>(curSet);
			newSet.remove(i);
			getAllSubsetsHelper (allNums,newSet);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public HashSet<ArrayList<Integer>> getAllSubsets (ArrayList<Integer> allNums){
//		HashSet<ArrayList<Integer>> finalAnswer = new HashSet<>();
////		getAllSubsetsHelper(finalAnswer,allNums);
//		finalAnswer.add(new ArrayList<>());	// manually adds the empty set	
//		getAllSubsetsHelper2(finalAnswer,0,allNums);
//		return finalAnswer;
//	}
//	
//	public void getAllSubsetsHelper(HashSet<ArrayList<Integer>> finalAnswer,ArrayList<Integer> nums) {
//		if (nums.size()==1 && !finalAnswer.contains(nums)) {
//			finalAnswer.add(new ArrayList<Integer>(nums));
//			return;
//		}
//		else if (nums.size()==1) return;
//		
//		for (int i=0;i<nums.size();i++) {
//			ArrayList<Integer> newNums = new ArrayList<>(nums);
//			newNums.remove(i);
//			finalAnswer.add(new ArrayList<Integer>(newNums));
//			getAllSubsetsHelper(finalAnswer,newNums);
//		}
//		finalAnswer.add(nums);
//	}
//	
//	public void getAllSubsetsHelper2(HashSet<ArrayList<Integer>> finalAnswer,int i,ArrayList<Integer> nums) {
//		ArrayList<Integer> newNums = new ArrayList<>(nums);
//		finalAnswer.add(newNums);
//		
//		if (i>=nums.size()) return;
//		
//		for (int j=0;j<nums.size();j++) {
//			newNums = new ArrayList<>(nums);
//			newNums.remove(j);
//			getAllSubsetsHelper2(finalAnswer,i+1,newNums);
//		}
//	}
}
