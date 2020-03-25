package com.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

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

	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(5);
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
	}

}
