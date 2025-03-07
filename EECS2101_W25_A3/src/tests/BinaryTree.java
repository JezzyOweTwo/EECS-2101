package tests;

public class BinaryTree<E>{
	public E el;
	public BinaryTree<E> left;
	public BinaryTree<E> right;
	public BinaryTree(E el, BinaryTree<E> left, BinaryTree<E> right) {
		this.el = el;
		this.left = left;
		this.right = right;
	}
	public BinaryTree(E el) {
		this.el = el;
		this.left = null;
		this.right= null;
	}

}
