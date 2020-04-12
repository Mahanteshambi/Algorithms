package com.algorithms.tree.bst;

public class LeastCommonAncestor {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	private Node findLCA(Node root, Node n1, Node n2) {
		while (root != null) {
			if (root.data > n1.data && root.data > n2.data) {
				root = root.left;
			} else if (root.data < n1.data && root.data < n2.data) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		LeastCommonAncestor obj = new LeastCommonAncestor();
		Node root = obj.new Node(20);
		root.left = obj.new Node(8);
		root.right = obj.new Node(22);
		root.left.left = obj.new Node(4);
		root.left.right = obj.new Node(12);
		root.left.right.left = obj.new Node(10);
		root.left.right.right = obj.new Node(14);

		System.out.println(obj.findLCA(root, obj.new Node(4), obj.new Node(12)).data);
		System.out.println(obj.findLCA(root, obj.new Node(12), obj.new Node(22)).data);
		System.out.println(obj.findLCA(root, obj.new Node(8), obj.new Node(12)).data);
	}
}
