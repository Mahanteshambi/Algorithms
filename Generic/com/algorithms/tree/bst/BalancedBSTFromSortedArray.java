package com.algorithms.tree.bst;

public class BalancedBSTFromSortedArray {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] str) {
		BalancedBSTFromSortedArray obj = new BalancedBSTFromSortedArray();
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		Node root = obj.constructBST(array, 0, array.length - 1);
		obj.inOrderTraversal(root);
	}

	private Node constructBST(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		Node root = new Node(array[mid]);
		root.left = constructBST(array, start, mid - 1);
		root.right = constructBST(array, mid + 1, end);
		return root;
	}

	private void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data + "");
		inOrderTraversal(root.right);
	}
}
