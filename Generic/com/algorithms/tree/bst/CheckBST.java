package com.algorithms.tree.bst;

public class CheckBST {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	private Node root;

	private boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data < min || root.data > max) {
			return false;
		}
		return (isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max));
	}

	public static void main(String[] args) {
		CheckBST tree = new CheckBST();
		tree.root = tree.new Node(4);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(5);
		tree.root.left.left = tree.new Node(1);
		tree.root.left.right = tree.new Node(3);
		System.out.println("Is tree BST: " + tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		tree.root = tree.new Node(3);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(5);
		tree.root.left.left = tree.new Node(1);
		tree.root.left.right = tree.new Node(4);
		System.out.println("Is tree BST: " + tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
