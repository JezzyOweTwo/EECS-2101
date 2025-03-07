
package model;
import tests.SLLNode;
import tests.TreeNode;
import tests.BinaryTree;

public class TreeUtilities{
	public TreeUtilities() {}
	
	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> node, int lower,int upper){
		SLLNode<Integer> sorted = new SLLNode<Integer>(0,null);
		sort (node,sorted);
		sorted = sorted.getNext();	// removes dummy node
		SLLNode<Integer>head=null;
		for (int i=1;i<upper+1;i++) {
			if(i==lower) head = sorted;
			if(i==upper) sorted.setNext(null);
			sorted = sorted.getNext();
		}
		return head;
	}
	
	public void sort (TreeNode<Integer> root,SLLNode<Integer> sorted) {
		if (root.getChildren()==null) {
			SLLNode<Integer> leaf = new SLLNode<>(root.getElement(),null);
			while (sorted.getNext()!=null && leaf.getElement()>sorted.getNext().getElement()) 
				sorted = sorted.getNext();
			
			leaf.setNext(sorted.getNext());
			sorted.setNext(leaf);
			return;
		}
		SLLNode<TreeNode<Integer>>kids = root.getChildren();
		while (kids!=null) {
			sort (kids.getElement(),sorted);
			kids = kids.getNext();
		}
		SLLNode<Integer> leaf = new SLLNode<>(root.getElement(),null);
		while (sorted.getNext()!=null && leaf.getElement()>sorted.getNext().getElement()) 
			sorted = sorted.getNext();
		leaf.setNext(sorted.getNext());
		sorted.setNext(leaf);
	}
	
//	public SLLNode<Integer> sortTreeHelper2(SLLNode<TreeNode<Integer>> kids){
//		if (head.getChildren()==null) {
//			SLLNode<Integer> leaf = new SLLNode<>(head.getElement(),null);
//			return leaf;
//		}
//		SLLNode<TreeNode<Integer>> sorted = 
//		while (kids!=null) {
//			// do some sort sorting on (kids.getElement().getElement());
//			kids = kids.getNext();
//		}
//		sortTreeHelper2(kids.getElement());
//	}
	
	
//	public SLLNode<Integer> sortTreeHelper(TreeNode<Integer> head){
//		if (head.getChildren()==null) {
//			SLLNode<Integer> leaf = new SLLNode<>(head.getElement(),null);
//			return leaf;
//		}	
//		
//		SLLNode<TreeNode<Integer>>kids = head.getChildren();
//		SLLNode<Integer> sortedList = new SLLNode<Integer>(null,null);
//		
//		while (kids!=null) {
//			SLLNode<Integer> subsorted = sortTreeHelper(kids.getElement());
//			// do some sorting to add subsorted to sortedList
//			kids = kids.getNext();
//		}
//		return sortedList;
//	}
//	 * Output:
//	 * 	Return the root node (see the TreeNode class) of a string tree which:
//	 * 		- has the same branching structure as the input integer tree (rooted at `n`)
//	 * 		- stores in each node a string summarizing the following statistical information of the ***corresponding input node***:
//	 * 			* Number of descendant nodes (See the definition of what a node's descendants are in Lecture W8.)
//	 * 			* Sum of values stored in the input descendant nodes
//	 * 
	public TreeNode<String> getStats(TreeNode<Integer> head){
		TreeNode<String> strHead = new TreeNode<>("dummmy");
		getStatsHelper(head,strHead);
		strHead = strHead.getChildren().getElement();	// dont return the dummy node
		strHead.setParent(null);	// manually fixes the parent
		return strHead;	
	}
	
	public long getStatsHelper(TreeNode<Integer> head,TreeNode<String> newTree){
		if (head.getChildren()==null) {
			String str = "Number of descendants: 1; Sum of descendants: "+head.getElement();
			TreeNode<String> node = new TreeNode<>(str);
			newTree.addChild(node);
			node.setParent(newTree);
			return  ((1<<16) + head.getElement());
		}           // # of Kids  // value of kids
	
		TreeNode<String> node = new TreeNode<>("This string will get replaced later in execution.");
		SLLNode<TreeNode<Integer>> kids = head.getChildren();
		long kidsandcursum=0;
		
		while (kids!=null) {
			kidsandcursum += getStatsHelper(kids.getElement(),node);
			kids = kids.getNext();
		}	// summates the total number of kids and the current value of kids.
						
						// # of Kids  // total value
		kidsandcursum += (1<<16) + head.getElement();			//adds current node to both totals
		long kidcount =  ((0xFFFF0000 & kidsandcursum) >> 16);	
		long cursum   =   (0x0000FFFF & kidsandcursum);
		
		String str = String.format("Number of descendants: %d; Sum of descendants: %d",kidcount,cursum);
		node.setElement(str);	// updates node's string to be it's actual value.
		newTree.addChild(node);
		node.setParent(newTree);
	
		return kidsandcursum;
	}
	
	// i'm using a short with bit manipulation to store curSUM and kidcount in one variable.
//	public long getStatsHelper2(TreeNode<Integer> head, TreeNode<String> stats){
//		if (head.getChildren()==null) {
//				 // # of Kids  // value of kids
//			return ((1<<16) + head.getElement());
//		}
//		SLLNode<TreeNode<Integer>>kids = head.getChildren();
//		long newkidsandcurSum=0;
//		long kidcount;
//		long cursum;
//		while (kids!=null) {
//			long kidsandcursum = getStatsHelper2(kids.getElement(),stats);
//			kidcount = (0xFFFF0000 & kidsandcursum) >> 16; // gotta bit shift cuz the number isn't at the beginning
//			cursum =    0x0000FFFF & kidsandcursum;
//			String str = String.format("Number of descendants: %d; Sum of descendants: %d",kidcount,cursum); 
//			TreeNode<String> statsnode = new TreeNode<>(str);
//			stats.addChild(statsnode);
//			statsnode.setParent(stats);
//			newkidsandcurSum += kidsandcursum;					// adds kids and cursum to total
//			kids = kids.getNext();
//		}
//		newkidsandcurSum += (1<<16);							// adds one kid to the total
//		newkidsandcurSum+= head.getElement();					// adds current element to total
//		kidcount = (0xFFFF0000 & newkidsandcurSum) >> 16;	
//		cursum = 0x0000FFFF & newkidsandcurSum;
//		stats.setElement(String.format("Number of descendants: %d; Sum of descendants: %d",kidcount,cursum));
//		// this BS is just to avoid top-level crashing
//		TreeNode<String> parent = (head.getParent()!=null) ? 
//									new TreeNode<String>(Integer.toString(head.getParent().getElement())):
//									null;
//		stats.setParent(parent);
//		return newkidsandcurSum;
//	}
	
	public boolean contains(BinaryTree<String> head,String target) {
		if (head==null) return false;
		if (head.el==target) return true;
		if (head.left==null && head.right==null) return false;	
		return contains(head.left,target) || contains(head.right,target);
	}
}
