package model;
import tests.Node;

public class ListUtilities {
	public ListUtilities() {}
	/*
	 * Given an input chain of integers, return a chain of strings.
	 * 
	 * Each string in the output chain is a prefix (i.e., first few numbers) of the input chain,
	 * 	whose length is between the specified lower and upper bounds (inclusive at both ends).
	 * 
	 * Each prefix should be formatted as a comma-separated list of integers, surrounded by a pair of square brackets.
	 *  
	 * Hints:
	 * 	+ The length of the output chain is equal to the length of the input chain. 
	 * 	+ Elements in the output chain are ``sorted'' by the lengths of the prefixes 
	 * 		(e.g,. the first element is the prefix of length 1, the second element is the prefix of length 2).
	 * 
	 * Assumptions:
	 *  + The input chain contains at least one node in it.
	 * 	+ For each call of getAllPrefixes(input, m, n):
	 * 		* The input chain is not null and contains at least one node.
	 * 		* m <= number of nodes in the input chain
	 * 		* n <= number of nodes in the input chain
	 * 		* m <= n 
	 */
	public Node<String> getAllPrefixes(Node<Integer> head,int minIndex, int maxIndex){
		Node <String> chainHead = new Node<>(null,null);
		Node <String> chainTail = chainHead;
		String allValues  = head.getElement().toString();
		
		for (int i=1;i<=maxIndex;i++) {
			if (i>=minIndex) {
				chainTail.setNext(new Node<String>("["+allValues+"]",null));
				chainTail = chainTail.getNext();
			}
			
			head = head.getNext();
			if (head==null) break;	// bullshit prevention
			allValues +=", "+head.getElement().toString();
		}
		return chainHead.getNext();	// my chain stars with null. I don't wanna return that.
	}
	/* 
	 * Merging two non-empty chains, each sorted in a non-descending order, 
	 * 	results in a new chain containing elements from both chains and sorted in a non-descending order.
	 * 
	 * Assumption: 
	 * 	- Each of the input chains to the getMergedChain method, if not null, is sorted in a non-descending order. 
	 */  
	public <T extends Comparable<T>> Node <T> getMergedChain(Node<T> leftChain, Node<T> rightChain){
		Node <T> newChain = new Node<T>(null,null);	// head of the new chain
		Node <T> tailPtr = newChain;				// tail of the new chain
		
		while (leftChain!=null||rightChain!=null) {
			// if you're outta left nodes, you only gotta use the right chain.
			if (leftChain==null) { 			
				tailPtr.setNext(new Node<T>(rightChain.getElement(),null));
				rightChain = rightChain.getNext();
			}
			
			// if you're outta right nodes, you should only take from the left chain.
			else if (rightChain==null) {	
				tailPtr.setNext(new Node<T>(leftChain.getElement(),null));
				leftChain = leftChain.getNext();
			}
			
			// if left < right, use left
			else if (leftChain.getElement().compareTo(rightChain.getElement())>0) {	
				tailPtr.setNext(new Node<T>(rightChain.getElement(),null));
				rightChain = rightChain.getNext();
			}
			
			// otherwise, use right
			else {
				tailPtr.setNext(new Node<T>(leftChain.getElement(),null));
				leftChain = leftChain.getNext();
			}
			tailPtr = tailPtr.getNext();	// iterates the tail ptr
		}	
		return newChain.getNext();	// makes sure i don't return the dummy node at the beginning.
	}
	
	/*
	 * Get a sequence interleaving elements from:
	 * 	- An arithmetic sequence, starting at 5 with a common difference 3, of size 4.
	 * 	- A Fibonacci sequence of size 1.
	 * 	  Recall. A Fibonacci sequence is infinite: <1, 1, 2, 3, 5, 8, 13, ...>  
	 * (The interleaving starts with one element from the arith. seq., then one element from the Fib. seq., and so on.)
	 */
	
	// this solution is n^2 for no reason, LOL.
	// its totally possible to do this in linear time if i just use a helper 
	// that keeps track of the current value of each sequence.
	public Node <Integer> getInterleavedArithmeticFibonacciSequences(int base,int step,int arithElements, int fibElements){
		int i=0,j=0;									// counter from arithElements and fibElements respectively
		Node<Integer> newHead = new Node<>(null,null);	// head of the linkedlist
		Node<Integer> newTail = newHead;				// tail of the linkedlist
		while (j<arithElements || i<fibElements) {
			
			// adds another number from the arithmatic sequence 
			if (j<arithElements) {
				newTail.setNext( new Node<Integer>(arithSeq(base,step,j),null));
				newTail = newTail.getNext();
				j++;
			}
			
			// adds another number from the fib seqeuence
			if (i<fibElements) {
				newTail.setNext( new Node<Integer>(fib(i),null));
				newTail = newTail.getNext();
				i++;
			}
		}
		return newHead.getNext();
	}
	
	// calculates fib for an arbitrary number
	private int fib(int num) {
		if (num==0||num==1) return 1;
		return fib(num-1) + fib(num-2);
	}
	
	// calculates the arithmatic seq for an arbitrary number
	private int arithSeq(int base,int step,int i) {
		return base + step*i;
	}
	
	/*
	 * Calling getGroupedStrings(input, m, n) returns a chain of nodes 
	 * 	which groups all elements from the input chain as follows, from left to right:
	 * 	Group 1: strings whose lengths are less than m
	 *  Group 2: strings whose lengths are greater than or equal to m and less than n
	 *  Group 3: strings whose lengths are greater than or equal to n
	 * 
	 * Requirements:
	 * 	- The input and output chains are equally long.
	 * 	- Each group in the output chain preserves the order in which its elements appear in the input chain.
	 * 
	 * Assumptions:
	 * 	- Assume that m <= n. 
	 * 	- When m = n, it means that group2 is empty. 
	 * 		(say m = n = 3: there is no string whose length is >= 3 and < 3).
	 */
	
	// this sol is HORRIBLY inefficient. but it works LOL. 
	// technically it's still O(n), buts its ugly o(n). [three passes needed]
	public Node<String>getGroupedStrings(Node<String> head, int m, int n){
		Node <String> headPtr = head;
		Node<String> chainHead = new Node<>(null,null);
		Node<String> chainTail = chainHead;
		
		// group 1
		while (headPtr!=null) {
			if (headPtr.getElement().length()<m) {
				chainTail.setNext(new Node<String>(headPtr.getElement(),null));
				chainTail = chainTail.getNext();
			}
			headPtr = headPtr.getNext();
		}
		headPtr = head;	// reset headptr back to head.
		
		// group 2
		while (headPtr!=null) {
			if (headPtr.getElement().length()>=m && headPtr.getElement().length()<n) {
				chainTail.setNext(new Node<String>(headPtr.getElement(),null));
				chainTail = chainTail.getNext();
			}
			headPtr = headPtr.getNext();
		}
		headPtr = head;	// reset headptr back to head.
		
		// group 3
		while (headPtr!=null) {
			if (headPtr.getElement().length()>=n) {
				chainTail.setNext(new Node<String>(headPtr.getElement(),null));
				chainTail = chainTail.getNext();
			}
			headPtr = headPtr.getNext();
		}
		headPtr = head;	// reset headptr back to head.
		return chainHead.getNext();
	}
}

// is it fair to assume <T extends Comparable<T>> ? 	