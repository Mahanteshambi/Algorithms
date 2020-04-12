package com.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
	Node root;

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	private void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + "");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	private void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.key + "");
		inOrderTraversal(root.right);
	}

	private void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.key + "");
	}

	private void levelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<TreeTraversal.Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.key);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private void reverseLevelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<TreeTraversal.Node>();
		Stack<Node> stack = new Stack<TreeTraversal.Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			stack.add(temp);
			if (temp.right != null) {
				queue.add(temp.right);
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}

		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().key + "");
		}
	}

	private void rightToLeftLevelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<TreeTraversal.Node>();
		Stack<Node> stack = new Stack<TreeTraversal.Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			stack.add(temp);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().key + "");
		}
	}

	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(5);
		tree.root.right.left = tree.new Node(6);
		tree.root.right.right = tree.new Node(7);
		System.out.println("Preorder: ");
		tree.preOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Inorder: ");
		tree.inOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Postorder: ");
		tree.postOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Level order: ");
		tree.levelOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Reverse Level order: ");
		tree.reverseLevelOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Reverse Level order: ");
		tree.rightToLeftLevelOrderTraversal(tree.root);
	}

}
