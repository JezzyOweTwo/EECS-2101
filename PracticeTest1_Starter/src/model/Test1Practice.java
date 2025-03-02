package model;
import java.util.ArrayList;

import tests.Node;
public class Test1Practice {
	
	static public <T> boolean hasCycle(Node<T> head) {
		ArrayList <Node<T>> visited = new ArrayList<>();
		while (true) {
			if (head==null|head.getNext()==null) return false;
			else if (visited.contains(head)) return true;
			head = head.getNext();
		}
	}
	static public<T extends Comparable<T>> Node<T> mergeSortedLists(Node<T> head1, Node<T> head2) {
		if (head1==null&&head2==null)return null;
		Node<T> newList = new Node<T>(null,null); 
		while (head1!=null||head2!=null) {
			if (head1==null) {
				newList.setNext(new Node<T>(head2.getElement(),null));
				head2 = head2.getNext();
			}
			if (head2==null) {
				newList.setNext(new Node<T>(head1.getElement(),null));
				head1 = head1.getNext();
			}
			else if (head1.getElement().compareTo(head2.getElement())<0) {
				newList.setNext(new Node<T>(head2.getElement(),null));
				head2 = head2.getNext();
			}
			else {
				newList.setNext(new Node<T>(head1.getElement(),null));
				head1 = head1.getNext();
			}
			newList = newList.getNext();
		}
		return newList.getNext();	
	}
	
	 public static<T> Node<T> findMiddle(Node<T> head){
		if (head==null) return null;
		Node<T> fp = head.getNext();
		Node<T> sp = head;
		
		while (fp!=null&&fp.getNext()!=null) {
			sp = sp.getNext();
			fp = fp.getNext().getNext();
		}
		return sp;
	}
	
	public static <T> Node<T> deleteNode(Node<T> node,T t){
		Node<T> head = new Node<T>(null,node);
		Node<T> prev = head;
		while(node!=null) {
			if (node.getElement()==t) 
				prev.setNext(node.getNext());
			prev = node;
			node = node.getNext();
		}	
		return head.getNext();
	}
	 

	
	public<T> Node<T> insertNode(Node<T>node,T t,int index) {
		node = new Node<T>(null,node);
		Node<T> dummyHead = node;
		for (int i=index+1;i>1;i--) {
			node = node.getNext();
		}
		
		Node<T> newNode = new Node<>(t,null);
		newNode.setNext(node.getNext());
		node.setNext(newNode);

		return dummyHead.getNext();
	}
	 
	static public<T> Node<T> removeDuplicates(Node<T> node) {
		Node<T> head = node;
		Node<T> prev=null;
		
		while (node!=null||node.getNext()!=null) {
			
			
			if (node.getElement()==prev.getElement()) {
				prev.setNext(prev.getNext().getNext());
			}
			
			prev = node;
			node = node.getNext();
		}
		
		return head;
	}
}
