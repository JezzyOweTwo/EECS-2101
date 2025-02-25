package model;

import tests.Node;

public class ListUtilities<T> {
	public ListUtilities(){}
	
	public Node<T> reverseOf(Node<T> node){
		Node<T> reversedHead = null;
		
		while (node!=null) {
			Node<T> tmp = new Node<>(node.getElement(),null);
			tmp.setNext(reversedHead);
			reversedHead = tmp;
			
			tmp = tmp.getNext();
			node=node.getNext();
		}
		return reversedHead;
	}
	
	public Node<T> copyOf(Node<T> node){
		Node<T> copy = new Node<>(null,null);
		Node<T> copyHead = copy;
		while (node!=null) {
			copy.setNext(new Node<>(node.getElement(),null));
			copy = copy.getNext();
			node = node.getNext();
		}
		return copyHead.getNext();
	}
	
	public Node<T> removeNthFromEnd(Node<T> head, int index){
		int nodeCount = 0;
		Node<T> tmp = head;
		while (tmp!=null) {
			nodeCount++;
			tmp=tmp.getNext();
		}
		
		int targetIndex  = nodeCount - index;
		
		if (index == nodeCount) { 
			head = head.getNext();
			return head;
		}
		
		tmp = head;
		
		for (int i=targetIndex;i>0;i--) {
			if (i==1) // stops right before target index
				tmp.setNext(tmp.getNext().getNext());	
			tmp = tmp.getNext();
		}
		
		return head;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public Node<T> reverseOf(Node<T> node){
////		Node<T> reversed = copyOf(node);
////		return reverseOfHelper(reversed);
//		return reverseOfHelper2(node);
//	}
//	
//	public Node<T>reverseOfHelper2(Node<T> head){
//		Node<T> reversedHead = null;
//		
//		while(head!=null) {
//			Node<T> tmp = new Node<>(head.getElement(),null);
//			tmp.setNext(reversedHead);
//			reversedHead = tmp;
//			head = head.getNext();
//		}
//
//		return reversedHead;
//	}
//	
//	public Node<T> reverseOfHelper(Node<T> node){
//		if (node==null||node.getNext()==null) return node;
//		
//		Node<T> reversed = reverseOfHelper(node.getNext());
//		node.getNext().setNext(node);
//		node.setNext(null);
//		return reversed;
//	}
//	
//	public Node<T> copyOf(Node <T> node){
//		if (node==null) return null;
//		Node<T> copyNode = new Node<>(null,null);
//		Node<T> head = copyNode;
//		while (node!=null) {
//			Node<T> temp = new Node<>(node.getElement(),null);
//			copyNode.setNext(temp);
//			copyNode = copyNode.getNext();
//			node = node.getNext();
//		}
//		return head.getNext();
//	}
//	
//	public Node<T> removeNthFromEnd(Node<T> head,int i){
//		int nodeCount = 0;
//		Node<T> tmp = head;
//		while(tmp!=null) {
//			nodeCount++;
//			tmp = tmp.getNext();
//		}
//		
//		int targetIndex = nodeCount-i;
//		
//		// if the first index is to be removed, just remove it and return.
//		if (targetIndex==0) {
//			head = head.getNext();
//			return head;
//		}
//		
//		tmp = head;
//		for (int j=targetIndex;j>0;j--) {
//			
//			// stops right before target index.
//			if (j==1) {
//				tmp.setNext(tmp.getNext().getNext());
//				break;
//			}		
//			tmp = tmp.getNext();
//		}
//		return head;
//	}
}
