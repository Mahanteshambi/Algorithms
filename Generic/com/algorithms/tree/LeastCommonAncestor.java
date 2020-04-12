package com.algorithms.tree;

public class LeastCommonAncestor {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	private Node findLCA(Node root, Node n1, Node n2) {
		if (root == null) {
			return null;
		}

		if (root.data == n1.data | root.data == n2.data) {
			return root;
		}

		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		LeastCommonAncestor obj = new LeastCommonAncestor();
		Node root = obj.new Node(3);
		root.left = obj.new Node(6);
		root.right = obj.new Node(8);
		root.left.left = obj.new Node(2);
		root.left.right = obj.new Node(11);
		root.left.right.left = obj.new Node(9);
		root.left.right.right = obj.new Node(5);
		root.right.right = obj.new Node(13);
		root.right.right.left = obj.new Node(7);

		System.out.println(obj.findLCA(root, obj.new Node(2), obj.new Node(11)).data);
		System.out.println(obj.findLCA(root, obj.new Node(2), obj.new Node(13)).data);
		System.out.println(obj.findLCA(root, obj.new Node(8), obj.new Node(7)).data);
	}
}
